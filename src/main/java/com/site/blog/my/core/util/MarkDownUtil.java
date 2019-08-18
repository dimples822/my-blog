package com.site.blog.my.core.util;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.util.StringUtils;

import java.util.Collections;

/**
 * md转换器
 *
 * @author zhongyj
 * @date 2019/8/7
 */
public class MarkDownUtil {
    /**
     * 转换md格式为html
     *
     * @param markdownString String
     * @return String
     */
    public static String mdToHtml(String markdownString) {
        if (StringUtils.isEmpty(markdownString)) {
            return "";
        }
        java.util.List<Extension> extensions = Collections.singletonList(TablesExtension.create());
        Parser parser = Parser.builder().extensions(extensions).build();
        Node document = parser.parse(markdownString);
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
        return renderer.render(document);
    }
}
