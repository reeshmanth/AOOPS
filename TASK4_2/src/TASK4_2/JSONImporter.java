package TASK4_2;

class JSONImporter extends DataImporter {
    @Override
    protected void readData(String filePath) {
        System.out.println("Reading JSON data from " + filePath);
        
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing JSON data...");
        
    }

    @Override
    protected void validateData() {
        System.out.println("Validating JSON data...");
        
    }
}
