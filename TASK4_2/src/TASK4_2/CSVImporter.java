package TASK4_2;

class CSVImporter extends DataImporter {
    @Override
    protected void readData(String filePath) {
        System.out.println("Reading CSV data from " + filePath);
       
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing CSV data...");
       
    }

    @Override
    protected void validateData() {
        System.out.println("Validating CSV data...");
       
    }
}