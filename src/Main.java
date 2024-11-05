import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        // 1. receive the new members and add them to the txt file
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name:");
        String name = input.next();
        System.out.println("Enter Surname:");
        String surname = input.next();
        System.out.println("Enter Miles:");
        double miles = input.nextDouble();

        Member mem = new Member(name, surname, miles);

        // Save the information on the txt file
        try {
            FileWriter file = new FileWriter("club.txt", true); // Append mode
            String s = mem.getName() + "," + mem.getSurname() + "," + mem.getMiles() + "\n";
            file.write(s);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. read the members from the txt
        Member[] members = HandlingTextFile.readMembersFromFile("club.txt");

        // 3. find the maximum walked distance
        double maxDistance = Member.findMaxDistance(members);
        System.out.println("The furthest distance walked is: " + maxDistance);

        // 4. calculate the 70% walked distance
        double threshold = maxDistance * 0.7;

        // 5. filter the members that walked more than the 70% of the max dic
        Member[] winners = Member.filterMembersByDistance(members, threshold);

        // 6. write down the members who pass the 70% max distance
        HandlingTextFile.writeWinnersToFile("winners.txt", winners);

        System.out.println("Names of members who walked more than 70% of the furthest distance have been written to winners.txt.");
    }
}
