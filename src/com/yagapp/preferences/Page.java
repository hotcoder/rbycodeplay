package com.yagapp.preferences;

import java.util.Comparator;
import java.util.List;

public class Page {

	String pageName;
	List<String> tagsList;
	Integer pageNumber;

	Integer totalWeight;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public List<String> getTagsList() {
		return tagsList;
	}

	public void setTagsList(List<String> tagsList) {
		this.tagsList = tagsList;
	}

	public Integer getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Integer totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public static Comparator<Page> PageComparator = new Comparator<Page>() {
		public int compare(Page p1, Page p2) {

			int value0 = p2.getTotalWeight().compareTo(p1.getTotalWeight());
			if (value0 == 0) {
				int value1 = p1.getPageNumber().compareTo(p2.getPageNumber());
				return value1;
			}
			return value0;
		}
	};

	@Override
	public String toString() {
		return "Page [pageName=" + pageName + ", tagsList=" + tagsList
				+ ", pageNumber=" + pageNumber + ", totalWeight=" + totalWeight
				+ "]";
	}

}
