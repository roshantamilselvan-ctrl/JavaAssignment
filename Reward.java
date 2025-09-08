package JavaProject;

public class Reward {
    private String rewardId;
    private String name; // Flight/Upgrade/Voucher
    private int milesRequired;
    private int availability;

    public Reward(String rewardId, String name, int milesRequired, int availability) {
        this.rewardId = rewardId;
        this.name = name;
        this.milesRequired = milesRequired;
        this.availability = availability;
    }

    public String getName() { return name; }
    public int getMilesRequired() { return milesRequired; }
    public int getAvailability() { return availability; }

    public void redeem(Member member) {
        if (availability <= 0) {
            System.out.println("Reward not available.");
            return;
        }
        if (member.getMilesBalance() >= milesRequired) {
            member.setMilesBalance(member.getMilesBalance() - milesRequired);
            availability--;
            System.out.println(member.getName() + " redeemed reward: " + name);
        } else {
            System.out.println("Insufficient miles for " + member.getName());
        }
    }

    public void printReward() {
        System.out.println("Reward: " + name + " | Miles: " + milesRequired + " | Available: " + availability);
    }
}

