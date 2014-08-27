package com.yagapp.preferences;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FetchPagesByQueryKeys {

	/**
	 * Method to accept the pages with tags from the user and prepares the list
	 * of instances Page class , input the word <b>EXIT</b>, if you want stop
	 * inputing the pages.
	 * 
	 * @return <b>pagesList</b> , list of instances of Page class Note : Method
	 *         will throw the exception and exit the process when the number of
	 *         tags assigned to a page exceeded more than 8. <b>So the limit is
	 *         8 tags per page</b>
	 */

	private static List<Page> preparePages() {
		System.out
				.println("Please start inputing the page with related tags seperated by space ,if want to exit the page input process type 'EXIT'\n");
		Scanner sc = new Scanner(System.in);
		List<Page> pagesList = new LinkedList<Page>();

		int pageNumber = 1;
		try {
			while (true) {
				String pageWithTags = sc.nextLine();
				if (pageWithTags.equalsIgnoreCase("EXIT")) {
					break;
				}
				pagesList.add(preparePageInstances(pageWithTags, pageNumber));
				pageNumber = pageNumber + 1;
			}
		} catch (Exception e) {
			System.out.println("Please assign max 8 tags per page");
			System.exit(0);
		}
		return pagesList;

	}

	/**
	 * Method to accept the queries with tags from the user and prepares the
	 * list of tags and assign to the related query in a map, input the word
	 * <b>EXIT</b>, if you want stop inputing the pages.
	 * 
	 * @return <b>queriesMap</b> , map representing the query with it's tags
	 *         Note : Method will throw the exception and exit the process when
	 *         the number of tags assigned to a query exceeded more than 8.
	 *         <b>So the limit is 8 tags per query</b>
	 */
	private static Map<String, List<String>> prepareQueriesMap() {
		System.out
				.println("Please start inputing the queries with related keywords seperated by space ,if want to exit the query input process type 'EXIT'\n");
		Map<String, List<String>> queriesMap = new LinkedHashMap<String, List<String>>();
		Scanner sc = new Scanner(System.in);

		while (true) {

			String query = sc.nextLine();

			if (query.equals("EXIT")) {
				break;
			}
			String[] queryWithKeyWords = query.split(" ");

			String qName = queryWithKeyWords[0];

			if (queryWithKeyWords.length > 9) {
				try {
					throw new Exception("Max 8 Tags Allowed Per query");
				} catch (Exception e) {
					System.exit(0);
				}

			}
			List<String> qKeyWords = new LinkedList<String>();

			for (int i = 1; i < queryWithKeyWords.length; i++) {

				qKeyWords.add(queryWithKeyWords[i]);

			}
			queriesMap.put(qName, qKeyWords);
		}
		return queriesMap;
	}

	/**
	 * Method to process the string which includes both page name and tags into
	 * a instance of Page class
	 * 
	 * @param pageWithTags
	 *            , page name and with tags related to that page , separated by
	 *            space
	 * @param pageNumber
	 *            , represents the page number
	 * @return page , instance of Page class
	 * @throws Exception
	 */
	private static Page preparePageInstances(String pageWithTags, int pageNumber)
			throws Exception {

		String[] s = pageWithTags.split(" ");
		List<String> tags = new LinkedList<String>();
		Page page = new Page();
		if (s.length > 9) {
			throw new Exception("Max 8 Tags Allowed Per page");
		}
		page.setPageName(s[0]);
		page.setPageNumber(pageNumber);
		for (int i = 1; i < s.length; i++) {
			tags.add(s[i]);
		}
		page.setTagsList(tags);
		return page;
	}

	/**
	 * Method which will start the searching process my taking input of pages
	 * and queries
	 */
	public void startSearch() {

		List<Page> pagesList = new LinkedList<Page>();

		pagesList = preparePages();

		Map<String, List<String>> queriesMap = prepareQueriesMap();

		List<String> result = search(queriesMap, pagesList);

		for (String s : result) {
			System.out.println(s);
		}

	}

	/**
	 * Computes the query to page mappings
	 * 
	 * @param qMap
	 * @param pMap
	 * @return
	 */
	private List<String> search(Map<String, List<String>> qMap, List<Page> pMap) {
		List<String> qtopAcco = new LinkedList<String>();

		for (Entry<String, List<String>> qEntry : qMap.entrySet()) {
			String qName = qEntry.getKey();

			for (Page page : pMap) {

				int pageWeight = calculateStrength(qEntry.getValue(),
						page.getTagsList());
				page.setTotalWeight(pageWeight);

			}

			Collections.sort(pMap, Page.PageComparator);
			String result = prepareResult(qName, pMap);
			qtopAcco.add(result);
		}

		return qtopAcco;

	}

	/**
	 * Method to prepare the result to render to the output
	 * 
	 * @param qName
	 * @param pMap
	 * @return result , string representing the query to pages mapping</br> For
	 *         example Q1 : P1 P2
	 */
	private static String prepareResult(String qName, List<Page> pMap) {

		String result = qName + ":";
		int i = 0;
		for (Page page : pMap) {
			if (i >= 5) {
				break;
			} else {
				if (page.getTotalWeight().intValue() != 0) {
					result = result + " " + page.getPageName() + " ";
				}
			}
			i = i + 1;
		}

		return result;
	}

	/**
	 * Calculates the total strength of the each key word in the query to the
	 * tag in the page
	 * 
	 * @param qKeys
	 * @param pageTags
	 * @return totalStrength
	 */
	public static int calculateStrength(List<String> qKeys,
			List<String> pageTags) {
		int totalStrength = 0;
		int qN = 8;
		int pN = 8;
		for (String qk : qKeys) {
			for (String pageTag : pageTags) {

				if (qk.equalsIgnoreCase(pageTag)) {
					totalStrength = totalStrength + (qN * pN);
				}

				pN = pN - 1;
			}
			qN = qN - 1;
		}
		return totalStrength;
	}

}
