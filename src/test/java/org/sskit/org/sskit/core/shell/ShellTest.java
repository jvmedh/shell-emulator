package org.sskit.org.sskit.core.shell;

import org.junit.Before;
import org.junit.Test;
import org.sskit.core.shell.Shell;
import org.sskit.core.shell.ShellConstants;

public class ShellTest {

    private String[] commands;

    @Before
    public void setUp() {
        if (ShellConstants.IS_OS_WINDOWS) {
            commands = new String[]{"echo \"This is windows Shell Test\"",
                    "md temp",
                    "cd temp",
                    "dir",
                    "cd ..",
                    "rmdir /fs temp"
            };
        } else {
            commands = new String[]{"echo \"This is Shell test for Unix based test\"",
                    "mkdir temp",
                    "cd temp",
                    "ls -lrt",
                    "cd ..",
                    "rm -rf temp"
            };
        }
    }

    @Test
    public void testSequenceOfCommands() {
        Shell shell = Shell.open();
        for (String command : commands) {
            System.out.println(String.format("[%s]: Executing command: %s", "ShellTest", command));
            int exitCode = shell.executeCommand(command);
            if (exitCode == 0) {
                System.out.println(String.format("[%s]: Command '%s' executed successfully", "ShellTest", command));
            } else {
                System.out.println(String.format("[%s]: Command '%s' failed with exitCode %s", "ShellTest", command, exitCode));
            }
        }
        shell.close();
    }
}
