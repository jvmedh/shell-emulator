package org.sskit.core.shell;

public class Utils {

    public static boolean isEmptyString(final String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmptyString(final String str) {
        return !isEmptyString(str);
    }

    public static String getSystemProperty(final String property) {
        try {
            return System.getProperty(property);
        } catch (final SecurityException ex) {
            return null;
        }
    }

    public static boolean getOsMatchesName(final String osName, final String osNamePrefix) {
        return isOSNameMatch(osName, osNamePrefix);
    }

    private static boolean isOSNameMatch(final String osName, final String osNamePrefix) {
        if (osName == null) {
            return false;
        }
        return osName.startsWith(osNamePrefix);
    }

    public static String getEnvironmentVariable(final String name, final String defaultValue) {
        try {
            final String value = System.getenv(name);
            return value == null ? defaultValue : value;
        } catch (final SecurityException ex) {
            return defaultValue;
        }
    }

}
