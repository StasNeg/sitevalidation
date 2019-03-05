package com.service.sitevalidation.to;

import java.util.concurrent.CopyOnWriteArraySet;

public class ValidatorResult {
    private final CopyOnWriteArraySet<URIState> errorsSites = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<URIState> validSites = new CopyOnWriteArraySet<>();

    public ValidatorResult() {
    }

    public boolean addError(URIState errorSite) {
        return errorsSites.add(errorSite);
    }

    public boolean addValid(URIState errorSite) {
        return validSites.add(errorSite);
    }

    public CopyOnWriteArraySet<URIState> getErrorsSites() {
        return errorsSites;
    }

    public CopyOnWriteArraySet<URIState> getValidSites() {
        return validSites;
    }
}
