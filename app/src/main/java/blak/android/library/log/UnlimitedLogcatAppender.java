package blak.android.library.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.android.LogcatAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;

import android.support.annotation.NonNull;
import android.util.Log;

public class UnlimitedLogcatAppender extends LogcatAppender {
    private static final int LOG_CHUNK_SIZE = 4000;

    @Override
    public void append(ILoggingEvent event) {
        if (!isStarted()) {
            return;
        }

        if (event.getLevel().levelInt == Level.OFF_INT) {
            return;
        }

        String tag = getTag(event);
        int logLevel = getLogLevel(event);
        if (!getCheckLoggable() || Log.isLoggable(tag, logLevel)) {
            log(event, tag);
        }
    }

    private static int getLogLevel(@NonNull ILoggingEvent event) {
        int levelInt = event.getLevel().levelInt;
        switch (levelInt) {
            case Level.ALL_INT:
            case Level.TRACE_INT:
                return Log.VERBOSE;

            case Level.DEBUG_INT:
                return Log.DEBUG;

            case Level.INFO_INT:
                return Log.INFO;

            case Level.WARN_INT:
                return Log.WARN;

            case Level.ERROR_INT:
                return Log.ERROR;

            default:
                throw new IllegalArgumentException("Unsupported levelInt: " + levelInt);
        }
    }

    private void log(@NonNull ILoggingEvent event, String tag) {
        String message = getMessage(event);
        for (int i = 0, len = message.length(); i < len; i += LOG_CHUNK_SIZE) {
            int end = Math.min(len, i + LOG_CHUNK_SIZE);
            logChunk(tag, message.substring(i, end), event.getLevel().levelInt);
        }
    }

    private String getMessage(@NonNull ILoggingEvent event) {
        return getEncoder().getLayout().doLayout(event);
    }

    private void logChunk(String tag, String message, int level) {
        switch (level) {
            case Level.ALL_INT:
            case Level.TRACE_INT:
                Log.v(tag, message);
                break;

            case Level.DEBUG_INT:
                Log.d(tag, message);
                break;

            case Level.INFO_INT:
                Log.i(tag, message);
                break;

            case Level.WARN_INT:
                Log.w(tag, message);
                break;

            case Level.ERROR_INT:
                Log.e(tag, message);
                break;
        }
    }
}
