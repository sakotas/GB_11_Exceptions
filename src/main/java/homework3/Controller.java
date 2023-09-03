package homework3;

import homework3.services.FileService;

public class Controller {
    public static void main(String[] args) {

        String path = "src/main/java/homework3/services/db/";
        String inFile = "source";
        String logFile = "logs";

        try {
            FileService.setLogFile(logFile);
            System.out.println("\nFile contents: \n");
            FileService.printFile(path, inFile);
            System.out.println();
            FileService.processFiles(path, inFile);
            for (String newFile : FileService.getLog().keySet()) {
                System.out.println("\nNew file contents: \n");
                FileService.printFile(path, newFile);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
