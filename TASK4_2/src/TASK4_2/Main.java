package TASK4_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file type (csv, xml, json): ");
        String fileType = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine().trim();

        DataImporter importer;

        switch (fileType) {
            case "csv":
                importer = new CSVImporter();
                break;
            case "xml":
                importer = new XMLImporter();
                break;
            case "json":
                importer = new JSONImporter();
                break;
            default:
                System.out.println("Invalid file type. Please enter csv, xml, or json.");
                scanner.close();
                return;
        }

        importer.importData(filePath);
        scanner.close();
    }
}