package com.service.sitevalidation.to;

import java.util.Objects;

public class URIState {
    private final String uri;
    private final int responceCode;

    public URIState(String uri, int responceCode) {
        this.uri = uri;
        this.responceCode = responceCode;
    }

    public String getUri() {
        return uri;
    }

    public int getResponceCode() {
        return responceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof URIState)) return false;
        URIState uriState = (URIState) o;
        return Objects.equals(uri, uriState.uri);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uri);
    }
}
