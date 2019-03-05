package com.service.sitevalidation.service;

import com.service.sitevalidation.to.URIState;
import com.service.sitevalidation.to.ValidatorResult;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.*;

@Service

public class ValidateLinks {

    private static final int THREADS_NUMBERS = 8;
    private static final ExecutorService siteValidationExecutor = Executors.newFixedThreadPool(THREADS_NUMBERS);
    private Logger logger = LoggerFactory.getLogger(ValidateLinks.class);
    private ValidatorResult result;

    public ValidatorResult validate(Set<String> links) {
        final CompletionService<Boolean> completionService = new ExecutorCompletionService<>(siteValidationExecutor);
        result = new ValidatorResult();
        links.forEach(link -> completionService.submit(() -> validateSite(link)));
        int counter = 0;
        while (counter < links.size()) {
            try {
                Future<Boolean> future = completionService.poll(10, TimeUnit.SECONDS);
                if (!future.get()) {
                    logger.warn("We have problem");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                counter++;
            }
        }
        return result;
    }

    private boolean validateSite(String link) {
        Connection.Response response = null;
        boolean connectionResult = false;
        try {
            response = Jsoup.connect(link)
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                    .timeout(9000)
                    .execute();
            logger.info("Worked thread:: " + Thread.currentThread().getName() + "::HTTP link::" + link);
            result.addValid(new URIState(link, response.statusCode()));
            connectionResult = true;
        } catch (Exception e) {
            result.addError(new URIState(String.format("%s find with Error message %s", link, e.getMessage()), 500));
        }
        return connectionResult;
    }
}
