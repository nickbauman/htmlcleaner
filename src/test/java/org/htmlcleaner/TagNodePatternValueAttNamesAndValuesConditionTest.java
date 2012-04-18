package org.htmlcleaner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import junit.framework.TestCase;

public class TagNodePatternValueAttNamesAndValuesConditionTest extends TestCase {

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
		TagNode result = node
				.findElementWithNameAndPatternAndAttNamesAndValues("h3",
						Pattern.compile("This is an error"), attrMap.keySet(),
						attrMap.values(), true, false);
		assertNotNull(result);
		assertEquals(attrMap, result.getAttributes());
		assertEquals("This is an error", result.getText().toString().trim());
	}

	public void testFindNested() throws Exception {
		TagNode node = cleaner
				.clean(new File("src/test/resources/test10.html"));
		Map<String, String> attrMap = new HashMap<String, String>();
		attrMap.put("id", "x");
		TagNode result = node
				.findElementWithNameAndPatternAndAttNamesAndValues("p",
						Pattern.compile("<li>abc</li>"), attrMap.keySet(),
						attrMap.values(), true, false);
		assertNotNull(result);
		assertEquals(attrMap, result.getAttributes());
		CleanerProperties props = CleanerProperties.getDefaultInstance();
		assertEquals("<ul> \n<li>abc</li> \n<li>xyz</li> </ul>", result.renderChildren(result,
				new BrowserCompactXmlSerializer(props)));
	}
	
	public void testFindNestedWithCompositeContent() throws Exception {
		TagNode node = cleaner
		.clean(new File("src/test/resources/test10.html"));
		Map<String, String> attrMap = new HashMap<String, String>();
		attrMap.put("id", "y");
		TagNode result = node
		.findElementWithNameAndPatternAndAttNamesAndValues("p",
				Pattern.compile(".*This is a content node chunk.*"), attrMap.keySet(),
				attrMap.values(), true, false);
		assertNotNull(result);
		assertEquals(attrMap, result.getAttributes());
		CleanerProperties props = CleanerProperties.getDefaultInstance();
		assertEquals("<p id=\"y\"> This is a content node chunk \n<span>This is another tag node</span> </p>", result.renderChildren(result,
				new BrowserCompactXmlSerializer(props)));
	}

	public void testGet() throws Exception {
		TagNode node = cleaner
				.clean(new File("src/test/resources/test10.html"));
		Map<String, String> attrMap = new HashMap<String, String>();
		attrMap.put("id", "error1");
		attrMap.put("class", "error");
		TagNode[] results = node
				.getElementsWithNameAndPatternAndAttNamesAndValues("h3",
						Pattern.compile("This is an error"), attrMap.keySet(),
						attrMap.values(), true, false);
		assertNotNull(results);
		assertEquals(1, results.length);
		for (int i = 0; i < results.length; i++) {
			for (Map.Entry<String, String> attrpair : attrMap.entrySet()) {
				assertEquals(attrpair.getValue(), results[i].getAttributes()
						.get(attrpair.getKey()));
			}
		}
		assertEquals("This is an error", results[0].getText().toString().trim());
	}
}
