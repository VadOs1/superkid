package com.gmail.dissa.vadim.superkid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class SeoController {

    // Producing robots.txt file for search engines
    @RequestMapping(value = "/robots.txt", produces = {"text/plain"}, method = RequestMethod.GET)
    @ResponseBody
    public String getRobotsTxt() {
        return "User-agent: *" +
                "\n" + "Disallow: /admin/" +
                "\n" + "Host: superkid.com.ua" +
                "\n" + "Sitemap: http://superkid.com.ua/sitemap.xml";
    }

    // Producing sitemap.xml file for search engines
    @RequestMapping(value = "/sitemap.xml", produces = {"application/xml"}, method = RequestMethod.GET)
    @ResponseBody
    public String getSiteMapXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<urlset\n" +
                "      xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\"\n" +
                "      xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "      xsi:schemaLocation=\"http://www.sitemaps.org/schemas/sitemap/0.9\n" +
                "            http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd\">\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/cart</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/300101</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/300102</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/300103</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/300104</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/300105</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/300106</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/300107</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/300108</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/400101</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/400102</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/400103</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/400104</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/400105</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/400106</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/400107</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/400108</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/500101</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/500102</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/500103</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/500104</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/500105</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/500106</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/500107</loc>\n" +
                "</url>\n" +
                "<url>\n" +
                "  <loc>http://superkid.com.ua/product/500108</loc>\n" +
                "</url>\n" +
                "</urlset>";
    }
}
