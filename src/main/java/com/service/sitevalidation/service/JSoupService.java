package com.service.sitevalidation.service;

import com.service.sitevalidation.NotFoundSiteExseption;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JSoupService {

    public static Document  getDocument(String uri) {
        try {
            return Jsoup.connect(validateProtocol(uri)).get();
        } catch (IOException e) {
            throw new NotFoundSiteExseption(e.getMessage());
        }
    }

    private static String validateProtocol(String validationSite) {
        return validationSite.matches("^(?i)http.*") ? validationSite : "http://" + validationSite;
    }
}
