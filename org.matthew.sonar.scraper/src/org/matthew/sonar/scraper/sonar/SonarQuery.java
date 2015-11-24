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

public class SonarQuery {
	boolean maxResultsReached;
	Paging paging;
	Issue[] issues;
	
	public static class Paging{
		private int pageIndex;
		private int pageSize;
		private int total;
		private String fTotal;
		private int pages;
		
		public int getPageIndex() {
			return pageIndex;
		}
		public void setPageIndex(int pageIndex) {
			this.pageIndex = pageIndex;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public String getfTotal() {
			return fTotal;
		}
		public void setfTotal(String fTotal) {
			this.fTotal = fTotal;
		}
		public int getPages() {
			return pages;
		}
		public void setPages(int pages) {
			this.pages = pages;
		}
	}
}

