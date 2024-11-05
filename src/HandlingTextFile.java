import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HandlingTextFile {

    // Method to read the members from the text file
    public static Member[] readMembersFromFile(String filename) {
        ArrayList<Member> memberList = new ArrayList<>();

        try (Scanner fread = new Scanner(new FileReader(filename))) {
            String line;
            while (fread.hasNext()) {
                line = fread.nextLine().trim();
                String[] items = line.split(",");
                if (items.length == 3) {
                    String name = items[0];
                    String surname = items[1];
                    double miles = Double.parseDouble(items[2]);
                    memberList.add(new Member(name, surname, miles));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return memberList.toArray(new Member[0]);
    }

    // Method to write the winner members
    public static void writeWinnersToFile(String outputFilename, Member[] winners) {
        try (FileWriter writer = new FileWriter(outputFilename)) {
            for (Member member : winners) {
                writer.write(member.getName() + " " + member.getSurname() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
