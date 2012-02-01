package org.htmlcleaner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class TagNodeAttNamesAndValuesConditionTest extends TestCase {

	private HtmlCleaner cleaner;

	protected void setUp() throws Exception {
		cleaner = new HtmlCleaner();
	}

	public void testFind() throws Exception {
		TagNode node = cleaner
				.clean(new File("src/test/resources/test10.html"));
		Map<String, String> attrMap = new HashMap<String, String>();
		attrMap.put("action", "hhh.action");
		attrMap.put("class", "cc2");
		TagNode result = node.findElementWithAttNamesAndValues(
				attrMap.keySet(), attrMap.values(), true);
		assertNotNull(result);
		assertEquals(attrMap, result.getAttributes());
	}

	public void testGet() throws Exception {
		TagNode node = cleaner
				.clean(new File("src/test/resources/test10.html"));
		Map<String, String> attrMap = new HashMap<String, String>();
		attrMap.put("type", "text");
		attrMap.put("size", "10");
		TagNode[] results = node.getElementsWithAttNamesAndValues(
				attrMap.keySet(), attrMap.values(), true);
		assertNotNull(results);
		assertEquals(2, results.length);
		for (int i = 0; i < results.length; i++) {
			for (Map.Entry<String, String> attrpair : attrMap.entrySet()) {
				assertEquals(attrpair.getValue(), results[i].getAttributes()
						.get(attrpair.getKey()));
			}
		}
	}

}
