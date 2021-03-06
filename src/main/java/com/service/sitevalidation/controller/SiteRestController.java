package com.service.sitevalidation.controller;

import com.service.sitevalidation.NotFoundSiteExseption;
import com.service.sitevalidation.service.EmailsParserService;
import com.service.sitevalidation.service.JSoupService;
import com.service.sitevalidation.service.SiteValidationService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class SiteRestController {

    private SiteValidationService service;
    private EmailsParserService emailsParserService;

    @Autowired
    public SiteRestController(SiteValidationService service, EmailsParserService emailsParserService) {
        this.service = service;
        this.emailsParserService = emailsParserService;
    }

    @PostMapping(path = "/link", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> validateSite(@RequestBody Map<String, String> payload) {
//      get web site
        String validationSite = payload.get("site");
        Map<String, Object> answer = new HashMap<>();
        if(Objects.isNull(validationSite) || validationSite.isEmpty()){
            answer.put("validHTTP", "false");
        }else{
            try {
                Document document = JSoupService.getDocument(validationSite);
                answer.put("HREFs", service.validateSite(document));
                answer.put("emails", emailsParserService.findEmails(document));
            }catch (NotFoundSiteExseption e){
                answer.put("SiteConnectionError",e.getMessage() );
            }
        }
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest")
                .buildAndExpand().toUri();
        return ResponseEntity.created(uriOfNewResource).body(answer);
    }

    @PostMapping(path = "/html", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> validateHTML(@RequestBody Map<String, String> payload) {
//      get web site
        String validationSite = payload.get("html");
        Map<String, Object> answer = new HashMap<>();
        if(Objects.isNull(validationSite) || validationSite.isEmpty()){
            answer.put("validHTML", "false");
        }else{
            try {
                Document document = JSoupService.getText(validationSite);
                answer.put("HREFs", service.validateSite(document));
                answer.put("emails", emailsParserService.findEmails(document));
            }catch (NotFoundSiteExseption e){
                answer.put("SiteConnectionError",e.getMessage() );
            }
        }
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest")
                .buildAndExpand().toUri();
        return ResponseEntity.created(uriOfNewResource).body(answer);
    }
}
