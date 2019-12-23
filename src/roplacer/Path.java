/**
 *
 * @author Snubby
 */
public class Path {
//path that will be used to access Roblox content
    private String path;
    
    /**
     * method called to find the used Roblox path folder from the running Roblox
     * process
     * 
     * @return whether the path has been found (is Roblox open ?)
     */
    public boolean pathFinder() {
        String oldPath = path;
        ProcessHandle.allProcesses()
            .forEach(process -> checkProcess(process.info()));
        return (!oldPath.equals(path));
    }
    
    /**
     * method pathFinder() calls upon for each process to check if it is Roblox.
     * 
     * @param process fed by pathFinder() above
     */
    public void checkProcess(ProcessHandle.Info process) {
        if (process.toString().startsWith("Roblox Game Client")) {
            path = process.commandLine().toString();
        }
    }
    
    public String getPath() {
        return path;
    }
 
    
    /*
    public static void main(String[] args) {
    ProcessHandle.allProcesses()
            .forEach(process -> System.out.println(processDetails(process)));
}

private static String processDetails(ProcessHandle process) {
    return String.format("%8d %8s %10s %26s %-40s",
            process.pid(),
            text(process.parent().map(ProcessHandle::pid)),
            text(process.info().user()),
            text(process.info().startInstant()),
            text(process.info().commandLine()));
}

private static String text(Optional<?> optional) {
    return optional.map(Object::toString).orElse("-");
}
    */
}
