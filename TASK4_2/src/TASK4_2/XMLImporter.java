package TASK4_2;

class XMLImporter extends DataImporter {
    @Override
    protected void readData(String filePath) {
        System.out.println("Reading XML data from " + filePath);
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing XML data...");
    }

    @Override
    protected void validateData() {
        System.out.println("Validating XML data...");
     
    }
}

