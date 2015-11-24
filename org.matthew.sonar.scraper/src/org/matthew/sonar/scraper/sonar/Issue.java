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

public class Issue {
	private String key;
	private String component;
	private int componentId;
	private String project;
	private String rule;
	private String status;
	private String severity;
	private String message;
	private String line;
	private String debt;
	private String creationDate;
	private String updateDate;
	private String fUpdateAge;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getDebt() {
		return debt;
	}

	public void setDebt(String debt) {
		this.debt = debt;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getfUpdateAge() {
		return fUpdateAge;
	}

	public void setfUpdateAge(String fUpdateAge) {
		this.fUpdateAge = fUpdateAge;
	}

	public int getDebtInMin() {
		if (debt == null)
			return 0;
		try {
			if (debt.endsWith("min"))
				return Integer.parseInt(debt.substring(0, debt.length() - 3));
			int time = Integer.parseInt(debt.substring(0, debt.length() - 1));
			if (debt.endsWith("h"))
				return time * 60;
			if (debt.endsWith("d"))
				return time * 60 * 8;

		} catch (NumberFormatException e) {

		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Issue other = (Issue) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(key).append(", ").append(component).append(", ").append(componentId).append(", ").append(project)
				.append(", ").append(rule).append(", ").append(status).append(", ").append(severity).append(", ")
				.append(line).append(", ").append(debt).append(", ").append(creationDate).append(", ")
				.append(updateDate).append(", ").append(fUpdateAge).append(", ").append(getDebtInMin());
		return builder.toString();
	}

	public static String getHeader() {
		StringBuilder builder = new StringBuilder();
		builder.append("key").append(", ").append("component").append(", ").append("componentId").append(", ")
				.append("project").append(", ").append("rule").append(", ").append("status").append(", ")
				.append("severity").append(", ").append("line").append(", ").append("debt").append(", ")
				.append("creation date").append(", ").append("update date").append(", ").append("update age")
				.append(", ").append("debt in minutes");
		return builder.toString();
	}

}
