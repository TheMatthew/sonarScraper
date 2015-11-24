/**
 * Copyright 2015 Ericsson and all 
 * 
 * Sonar Scraper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Sonar Scraper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Sonar Scraper.  If not, see <http ://www.gnu.org/licenses/>.
 */

package org.matthew.sonar.scraper.sonar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

/**
 * Example scraper
 * 
 * @author Matthew Khouzam
 *
 */
public class test {

	private static final String SONAR_URL = "https://dev.eclipse.org/sonar";
	private static final String COMPONENT = "org.eclipse.tracecompass:org.eclipse.tracecompass";

	public static void main(String[] args) throws IOException {
		int page = 1;
		List<Issue> issues = new ArrayList<>();
		SonarQuery sq;
		do {
			String urlString = SONAR_URL + "/api/issues/search?componentRoots=" + COMPONENT
					+ "&pageSize=500&pageIndex=";
			URL url = new URL(urlString + Integer.toString(page));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int responseCode = con.getResponseCode();
			if (responseCode != 200)
				throw new IOException("Error in connection " + con.getResponseCode() + " " + con.getResponseMessage());
			System.out.print('.');
			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
				Gson gson = new Gson();
				sq = gson.fromJson(in, SonarQuery.class);
			}
			issues.addAll(Arrays.asList(sq.issues));
			page++;
		} while (sq.paging.getPages() > sq.paging.getPageIndex() && sq.issues.length != 0);
		File file = new File("sonar.csv");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(Issue.getHeader());
			bw.newLine();
			for (Issue issue : issues) {
				bw.write(issue.toString());
				bw.newLine();
			}
			System.out.println("\nWrote output to " + file.getAbsolutePath());
		}

	}

}
