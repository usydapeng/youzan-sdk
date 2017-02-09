package org.zunpeng.utils;

import org.jsoup.safety.Whitelist;

public class JsoupWhiteListEnhance {

	public static Whitelist relaxed() {
		return new Whitelist()
				.addTags("a", "b", "blockquote", "br", "caption", "cite", "code", "col",
						"colgroup", "dd", "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6",
						"i", "img", "li", "ol", "p", "pre", "q", "small", "strike",
						"sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr",
						"ul", "strong", "embed")

				.addAttributes("blockquote", "cite")
				.addAttributes("col", "span", "width")
				.addAttributes("colgroup", "span", "width")
				.addAttributes("img", "align", "alt", "height", "src", "title", "width", "data")
				.addAttributes("ol", "start", "type")
				.addAttributes("q", "cite")
				.addAttributes("table", "summary", "width")
				.addAttributes("td", "abbr", "axis", "colspan", "rowspan", "width")
				.addAttributes("th", "abbr", "axis", "colspan", "rowspan", "scope", "width")
				.addAttributes("ul", "type")
				.addAttributes("p", "style")
				.addAttributes("span", "style")
				.addAttributes("h1", "style")
				.addAttributes("h2", "style")
				.addAttributes("div", "style")
				.addAttributes("strong", "style")
				.addAttributes("a", "href", "title")
				.addAttributes("embed", "type", "class", "pluginspage", "src", "width", "height", "wmode", "play", "loop", "menu", "allowscriptaccess", "allowfullscreen")

				.addProtocols("embed", "src", "ftp", "http", "https", "mailto")
				.addProtocols("embed", "pluginspage", "ftp", "http", "https", "mailto")
				.addProtocols("a", "href", "ftp", "http", "https", "mailto")
				.addProtocols("blockquote", "cite", "http", "https")
				.addProtocols("img", "src", "http", "https")
				.addProtocols("q", "cite", "http", "https");
	}

	public static Whitelist relaxedWithoutA() {
		return new Whitelist()
				.addTags("b", "blockquote", "br", "caption", "cite", "code", "col",
						"colgroup", "dd", "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6",
						"i", "img", "li", "ol", "p", "pre", "q", "small", "strike",
						"sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr",
						"ul", "strong")

				.addAttributes("blockquote", "cite")
				.addAttributes("col", "span", "width")
				.addAttributes("colgroup", "span", "width")
				.addAttributes("img", "align", "alt", "height", "src", "title", "width", "data")
				.addAttributes("ol", "start", "type")
				.addAttributes("q", "cite")
				.addAttributes("table", "summary", "width")
				.addAttributes("td", "abbr", "axis", "colspan", "rowspan", "width")
				.addAttributes("th", "abbr", "axis", "colspan", "rowspan", "scope", "width")
				.addAttributes("ul", "type")
				.addAttributes("p", "style")
				.addAttributes("span", "style")
				.addAttributes("h1", "style")
				.addAttributes("h2", "style")
				.addAttributes("div", "style")
				.addAttributes("strong", "style")

				.addProtocols("blockquote", "cite", "http", "https")
				.addProtocols("img", "src", "http", "https")
				.addProtocols("q", "cite", "http", "https");
	}


}
