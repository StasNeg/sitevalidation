package com.service.sitevalidation;

public class NotFoundSiteExseption extends RuntimeException{
    public NotFoundSiteExseption(String message) {
        super(message);
    }
}
