package org.htmlcleaner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class TagNodeNameAttNamesAndValuesConditionTest extends TestCase {

	private HtmlCleaner cleaner;

	protected void setUp() throws Exception {
		cleaner = new HtmlCleaner();
	}

	public void testFind() throws Exception {
		TagNode node = cleaner
				.clean(new File("src/test/resources/test10.html"));
		Map<String, String> attrMap = new HashMap<String, String>();
		attrMap.put("id", "error1");
		attrMap.put("class", "error");
		TagNode result = node.findElementWithNameAndAttNamesAndValues("h3",
				attrMap.keySet(), attrMap.values(), true, false);
		assertNotNull(result);
		assertEquals(attrMap, result.getAttributes());
		assertEquals("This is an error", result.getText().toString());
	}

	public void testGet() throws Exception {
		TagNode node = cleaner
				.clean(new File("src/test/resources/test10.html"));
		Map<String, String> attrMap = new HashMap<String, String>();
		attrMap.put("id", "error1");
		attrMap.put("class", "error");
		TagNode[] results = node.getElementsWithNameAndAttNamesAndValues("h3", 
				attrMap.keySet(), attrMap.values(), true, false);
		assertNotNull(results);
		assertEquals(2, results.length);
		for (int i = 0; i < results.length; i++) {
			for (Map.Entry<String, String> attrpair : attrMap.entrySet()) {
				assertEquals(attrpair.getValue(), results[i].getAttributes()
						.get(attrpair.getKey()));
			}
		}
		assertEquals("This is an error", results[0].getText().toString());
	}
}
