/*  Copyright (c) 2006-2007, Vladimir Nikic
    All rights reserved.

    Redistribution and use of this software in source and binary forms,
    with or without modification, are permitted provided that the following
    conditions are met:

 * Redistributions of source code must retain the above
      copyright notice, this list of conditions and the
      following disclaimer.

 * Redistributions in binary form must reproduce the above
      copyright notice, this list of conditions and the
      following disclaimer in the documentation and/or other
      materials provided with the distribution.

 * The name of HtmlCleaner may not be used to endorse or promote
      products derived from this software without specific prior
      written permission.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
    AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
    IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
    ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
    LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
    CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
    SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
    INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
    CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
    ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
    POSSIBILITY OF SUCH DAMAGE.

    You can contact Vladimir Nikic by sending e-mail to
    nikic_vladimir@yahoo.com. Please include the word "HtmlCleaner" in the
    subject line.
 */

package org.htmlcleaner;

/**
 * Properties defining cleaner's behaviour
 */
public class CleanerProperties {

	public static final String BOOL_ATT_SELF = "self";
	public static final String BOOL_ATT_EMPTY = "empty";
	public static final String BOOL_ATT_TRUE = "true";

	ITagInfoProvider tagInfoProvider = null;

	boolean advancedXmlEscape = true;

	boolean transResCharsToNCR = false;
	boolean useCdataForScriptAndStyle = true;
	boolean translateSpecialEntities = true;
	boolean transSpecialEntitiesToNCR = false;
	boolean recognizeUnicodeChars = true;
	boolean omitUnknownTags = false;
	boolean treatUnknownTagsAsContent = false;
	boolean omitDeprecatedTags = false;
	boolean treatDeprecatedTagsAsContent = false;
	boolean omitComments = false;
	boolean omitXmlDeclaration = false;
	boolean omitDoctypeDeclaration = true;
	boolean omitHtmlEnvelope = false;
	boolean useEmptyElementTags = true;
	boolean allowMultiWordAttributes = true;
	boolean allowHtmlInsideAttributes = false;
	boolean ignoreQuestAndExclam = true;
	boolean namespacesAware = true;
	String hyphenReplacementInComment = "=";
	String pruneTags = null;
	String booleanAttributeValues = BOOL_ATT_SELF;

	public String getBooleanAttributeValues() {
		return booleanAttributeValues;
	}

	public String getHyphenReplacementInComment() {
		return hyphenReplacementInComment;
	}

	public String getPruneTags() {
		return pruneTags;
	}

	public ITagInfoProvider getTagInfoProvider() {
		return tagInfoProvider;
	}

	public boolean isAdvancedXmlEscape() {
		return advancedXmlEscape;
	}

	public boolean isAllowHtmlInsideAttributes() {
		return allowHtmlInsideAttributes;
	}

	public boolean isAllowMultiWordAttributes() {
		return allowMultiWordAttributes;
	}

	public boolean isIgnoreQuestAndExclam() {
		return ignoreQuestAndExclam;
	}

	public boolean isNamespacesAware() {
		return namespacesAware;
	}

	public boolean isOmitComments() {
		return omitComments;
	}

	public boolean isOmitDeprecatedTags() {
		return omitDeprecatedTags;
	}

	public boolean isOmitDoctypeDeclaration() {
		return omitDoctypeDeclaration;
	}

	public boolean isOmitHtmlEnvelope() {
		return omitHtmlEnvelope;
	}

	public boolean isOmitUnknownTags() {
		return omitUnknownTags;
	}

	public boolean isOmitXmlDeclaration() {
		return omitXmlDeclaration;
	}

	public boolean isRecognizeUnicodeChars() {
		return recognizeUnicodeChars;
	}

	public boolean isTranslateSpecialEntities() {
		return translateSpecialEntities;
	}

	public boolean isTransResCharsToNCR() {
		return transResCharsToNCR;
	}

	public boolean isTransSpecialEntitiesToNCR() {
		return transSpecialEntitiesToNCR;
	}

	public boolean isTreatDeprecatedTagsAsContent() {
		return treatDeprecatedTagsAsContent;
	}

	public boolean isTreatUnknownTagsAsContent() {
		return treatUnknownTagsAsContent;
	}

	public boolean isUseCdataForScriptAndStyle() {
		return useCdataForScriptAndStyle;
	}

	public boolean isUseEmptyElementTags() {
		return useEmptyElementTags;
	}

	public void setAdvancedXmlEscape(boolean advancedXmlEscape) {
		this.advancedXmlEscape = advancedXmlEscape;
	}

	public void setAllowHtmlInsideAttributes(boolean allowHtmlInsideAttributes) {
		this.allowHtmlInsideAttributes = allowHtmlInsideAttributes;
	}

	public void setAllowMultiWordAttributes(boolean allowMultiWordAttributes) {
		this.allowMultiWordAttributes = allowMultiWordAttributes;
	}

	public void setBooleanAttributeValues(String booleanAttributeValues) {
		if (BOOL_ATT_SELF.equalsIgnoreCase(booleanAttributeValues)
				|| BOOL_ATT_EMPTY.equalsIgnoreCase(booleanAttributeValues)
				|| BOOL_ATT_TRUE.equalsIgnoreCase(booleanAttributeValues)) {
			this.booleanAttributeValues = booleanAttributeValues.toLowerCase();
		} else {
			this.booleanAttributeValues = BOOL_ATT_SELF;
		}
	}

	public void setHyphenReplacementInComment(String hyphenReplacementInComment) {
		this.hyphenReplacementInComment = hyphenReplacementInComment;
	}

	public void setIgnoreQuestAndExclam(boolean ignoreQuestAndExclam) {
		this.ignoreQuestAndExclam = ignoreQuestAndExclam;
	}

	public void setNamespacesAware(boolean namespacesAware) {
		this.namespacesAware = namespacesAware;
	}

	public void setOmitComments(boolean omitComments) {
		this.omitComments = omitComments;
	}

	public void setOmitDeprecatedTags(boolean omitDeprecatedTags) {
		this.omitDeprecatedTags = omitDeprecatedTags;
	}

	public void setOmitDoctypeDeclaration(boolean omitDoctypeDeclaration) {
		this.omitDoctypeDeclaration = omitDoctypeDeclaration;
	}

	public void setOmitHtmlEnvelope(boolean omitHtmlEnvelope) {
		this.omitHtmlEnvelope = omitHtmlEnvelope;
	}

	public void setOmitUnknownTags(boolean omitUnknownTags) {
		this.omitUnknownTags = omitUnknownTags;
	}

	public void setOmitXmlDeclaration(boolean omitXmlDeclaration) {
		this.omitXmlDeclaration = omitXmlDeclaration;
	}

	public void setPruneTags(String pruneTags) {
		this.pruneTags = pruneTags;
	}

	public void setRecognizeUnicodeChars(boolean recognizeUnicodeChars) {
		this.recognizeUnicodeChars = recognizeUnicodeChars;
	}

	public void setTagInfoProvider(ITagInfoProvider tagInfoProvider) {
		this.tagInfoProvider = tagInfoProvider;
	}

	public void setTranslateSpecialEntities(boolean translateSpecialEntities) {
		this.translateSpecialEntities = translateSpecialEntities;
	}

	public void setTransResCharsToNCR(boolean transResCharsToNCR) {
		this.transResCharsToNCR = transResCharsToNCR;
	}

	public void setTransSpecialEntitiesToNCR(boolean transSpecialEntitiesToNCR) {
		this.transSpecialEntitiesToNCR = transSpecialEntitiesToNCR;
	}

	public void setTreatDeprecatedTagsAsContent(
			boolean treatDeprecatedTagsAsContent) {
		this.treatDeprecatedTagsAsContent = treatDeprecatedTagsAsContent;
	}

	public void setTreatUnknownTagsAsContent(boolean treatUnknownTagsAsContent) {
		this.treatUnknownTagsAsContent = treatUnknownTagsAsContent;
	}

	public void setUseCdataForScriptAndStyle(boolean useCdataForScriptAndStyle) {
		this.useCdataForScriptAndStyle = useCdataForScriptAndStyle;
	}

	public void setUseEmptyElementTags(boolean useEmptyElementTags) {
		this.useEmptyElementTags = useEmptyElementTags;
	}

	public static CleanerProperties getDefaultInstance() {
		CleanerProperties props = new CleanerProperties();
		props = new CleanerProperties();
		props.setTagInfoProvider(DefaultTagProvider.getInstance());
		props.setOmitXmlDeclaration(true);
		props.setTranslateSpecialEntities(true);
		props.setTransResCharsToNCR(true);
		props.setOmitComments(true);
		props.setTagInfoProvider(DefaultTagProvider.getInstance());
		return props;
	}

}