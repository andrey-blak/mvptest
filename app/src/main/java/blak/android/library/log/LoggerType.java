package blak.android.library.log;

public enum LoggerType {
    LOGCAT(Pattern.TRACE);

    private final Pattern mPattern;

    LoggerType() {
        this(Pattern.TRACE);
    }

    LoggerType(Pattern pattern) {
        mPattern = pattern;
    }

    Pattern getPattern() {
        return mPattern;
    }
}
