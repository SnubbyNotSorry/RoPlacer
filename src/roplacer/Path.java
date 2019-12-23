package roplacer;

/**
 *
 * @author Snubby
 */
public class Path {
    
    //path that will be used to access Roblox content
    private String path;
    
    public Path() {
    }
    
    /**
     * method called to find the used Roblox path folder from the running Roblox
     * process
     * 
     * @return whether the path has been found (is Roblox open ?). Logic behind
     * it is that if the path finishes different than how it started, then it
     * has been found. Will be useful later on for when Roblox updates.
     */
    public boolean pathFinder() {
        String oldPath = path;
        ProcessHandle.allProcesses()
            .forEach(process -> checkProcess(process.info()));
        return (oldPath != path);
    }
    
    /**
     * method pathFinder() calls upon for each process to check if it is Roblox.
     * 
     * @param process fed by pathFinder() above
     */
    public void checkProcess(ProcessHandle.Info process) {
        if (process.command().toString().endsWith("RobloxPlayerBeta.exe]")) {
            //Roblox has been found, set path.
            path = process.command().toString();
        }
    }
    
    public String getPath() {
        return path;
    }
    
}
