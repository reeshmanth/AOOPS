package TASK2;

import java.util.Scanner;

public class MusicStreamingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a music source:");
        System.out.println("1. Local File");
        System.out.println("2. Online Streaming");
        System.out.println("3. Radio Station");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        MusicSource musicSource = null;
        switch (choice) {
            case 1:
                System.out.print("Enter the local file path: ");
                String filePath = scanner.nextLine();
                musicSource = new LocalFileAdapter(filePath);
                break;
            case 2:
                System.out.print("Enter the streaming URL: ");
                String streamingUrl = scanner.nextLine();
                musicSource = new OnlineStreamingAdapter(streamingUrl);
                break;
            case 3:
                System.out.print("Enter the radio station URL: ");
                String stationUrl = scanner.nextLine();
                musicSource = new RadioStationAdapter(stationUrl);
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }
        MusicPlayer musicPlayer = new AdvancedMusicPlayer(musicSource);
        MusicPlayer enhancedMusicPlayer = new EqualizerDecorator(new VolumeControlDecorator(musicPlayer));
        enhancedMusicPlayer.playMusic(musicSource.getSourceDetails());
        scanner.close();    
    }
}

