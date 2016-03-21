package blak.android.library.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Context;
import org.slf4j.LoggerFactory;

public class Log {
    public static void init() {
        initLoggers();
    }

    public static org.slf4j.Logger logger(LoggerType type) {
        return LoggerFactory.getLogger(type.name());
    }

    private static void initLoggers() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.reset();
        for (LoggerType loggerType : LoggerType.values()) {
            Logger logger = (Logger) logger(loggerType);
            initLogger(loggerContext, logger, loggerType);
        }
    }

    private static void initLogger(Context loggerContext, Logger logger, LoggerType type) {
        AppenderBase<ILoggingEvent> logcatAppender = createLogcatAppender(loggerContext, type);
        logger.addAppender(logcatAppender);
        logger.setLevel(Level.ALL);
    }

    private static AppenderBase<ILoggingEvent> createLogcatAppender(Context loggerContext, LoggerType type) {
        PatternLayoutEncoder encoder = createPatternLayoutEncoder(loggerContext, type);
        UnlimitedLogcatAppender logcatAppender = new UnlimitedLogcatAppender();
        logcatAppender.setContext(loggerContext);
        logcatAppender.setEncoder(encoder);
        logcatAppender.start();
        return logcatAppender;
    }

    private static PatternLayoutEncoder createPatternLayoutEncoder(Context loggerContext, LoggerType loggerType) {
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(loggerContext);
        encoder.setPattern(loggerType.getPattern().getValue());
        encoder.start();
        return encoder;
    }
}
