package com.suren.universitymanagement.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger {

    private static final Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

}
