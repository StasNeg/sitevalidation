package com.service.sitevalidation.service;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailsParserService {

    public Set<String> findEmails(Document parsedDoc) {
        Pattern p = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
        Matcher matcher = p.matcher(parsedDoc.text());
        Set<String> emails = new HashSet<>();
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

}
