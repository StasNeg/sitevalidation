package com.service.sitevalidation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JsonPrepare {

    @Test
    public void getJsonHTML() throws JsonProcessingException {
        String testData = "<HTML>" +
                "" +
                "<HEAD>" +
                "" +
                "<TITLE>Your Title Here</TITLE>" +
                "" +
                "</HEAD>" +
                "" +
                "<BODY BGCOLOR=\"FFFFFF\">" +
                "" +
                "<CENTER><IMG SRC=\"clouds.jpg\" ALIGN=\"BOTTOM\"> </CENTER>" +
                "" +
                "<HR>" +
                "" +
                "<a href=\"http://somegreatsite.com\">Link Name</a>" +
                "" +
                "is a link to another nifty site" +
                "" +
                "<H1>This is a Header</H1>" +
                "" +
                "<H2>This is a Medium Header</H2>" +
                "" +
                "Send me mail at <a href=\"mailto:support@yourcompany.com\">" +
                "" +
                "support@yourcompany.com</a>." +
                "" +
                "<P> This is a new paragraph!" +
                "" +
                "<P> <B>This is a new paragraph!</B>" +
                "" +
                "<BR> <B><I>This is a new sentence without a paragraph break, in bold italics.</I></B>" +
                "" +
                "<HR>" +
                "" +
                "</BODY>" +
                "" +
                "</HTML>";
        Map<String,String> testJSon = new HashMap<>();
        testJSon.put("http",testData);
        System.out.println(new ObjectMapper().writeValueAsString(testJSon));
    }

}
