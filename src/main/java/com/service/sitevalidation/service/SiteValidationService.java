package com.service.sitevalidation.service;

import com.service.sitevalidation.to.ValidatorResult;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SiteValidationService {
    private ValidateLinks validator;

    @Autowired
    public SiteValidationService(ValidateLinks validator) {
        this.validator = validator;
    }


    public ValidatorResult validateSite(Document parsedSite) {
        Set<String> result = new HashSet<>();
        Elements links = parsedSite.select("a[href]");
        links.forEach(link -> result.add(link.attr("abs:href")));
        return validator.validate(result);
    }


}
