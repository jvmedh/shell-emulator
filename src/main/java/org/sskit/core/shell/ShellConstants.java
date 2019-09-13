package org.sskit.core.shell;

/*
 * Shell Environment Constants
 */
public class ShellConstants {

    private static final String  OS_NAME_WINDOWS_PREFIX     = "Windows";
    public static final  String  WINDOWS_COMMAND_PROGRAM    = "cmd.exe";
    private static final String  USER_DIR_KEY               = "user.dir";
    public static final  String  DEFAULT_UNIX_SHELL         = "/bin/bash";
    public static final  String  EXIT_STATUS_COMMAND_PREFIX = "ERRORCODE: ";
    public static final  String  LINUX_SHELL                = Utils.getEnvironmentVariable("SHELL", DEFAULT_UNIX_SHELL);
    public static final  String  OS_NAME                    = Utils.getSystemProperty("os.name");
    public static final  String  USER_DIR                   = Utils.getSystemProperty(USER_DIR_KEY);
    public static final  boolean IS_OS_WINDOWS              = Utils.getOsMatchesName(OS_NAME, OS_NAME_WINDOWS_PREFIX);
    public static final  String  EXIT_STATUS_COMMAND        = String.format("echo %s%s", EXIT_STATUS_COMMAND_PREFIX, IS_OS_WINDOWS ? "%errorlevel%" : "$?");

    private ShellConstants() {
        // preventing instantiation
    }

}
