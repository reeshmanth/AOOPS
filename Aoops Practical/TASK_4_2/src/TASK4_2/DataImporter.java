package TASK4_2;

import java.io.File;

abstract class DataImporter {
    
    public final void importData(String filePath) {
        try {
            if (!validateFilePath(filePath)) {
                System.out.println("Invalid file path. Please try again.");
                return;
            }
            readData(filePath);
            parseData();
            validateData();
            saveData();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    
    protected abstract void readData(String filePath);
    protected abstract void parseData();
    protected abstract void validateData();
    
    
    protected void saveData() {
        System.out.println("Saving data to the database...");
    
    }

    
    private boolean validateFilePath(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
}

