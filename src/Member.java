import java.util.ArrayList;

public class Member {
    private String name;
    private String surname;
    private double miles;

    public Member() {
        name = "";
        surname = "";
        miles = 0;
    }

    public Member(String name, String surname, double miles) {
        this.name = name;
        this.surname = surname;
        this.miles = miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getMiles() {
        return miles;
    }

    // Method to find the max distance
    public static double findMaxDistance(Member[] members) {
        double maxDistance = 0;
        for (Member member : members) {
            if (member.getMiles() > maxDistance) {
                maxDistance = member.getMiles();
            }
        }
        return maxDistance;
    }

    // Method to find the members who walked more than the 70% Max dist.
    public static Member[] filterMembersByDistance(Member[] members, double threshold) {
        ArrayList<Member> filteredMembers = new ArrayList<>();
        for (Member member : members) {
            if (member.getMiles() >= threshold) {
                filteredMembers.add(member);
            }
        }
        return filteredMembers.toArray(new Member[0]);
    }
}
