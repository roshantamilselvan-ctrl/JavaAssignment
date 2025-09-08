package JavaProject;

public class GoldMember extends Member {
    public GoldMember(String memberId, String name, String email) {
        super(memberId, name, email);
        this.tier = "Gold";
    }

    @Override
    public double getBonusMultiplier() { return 1.25; }

    @Override
    public void evaluateTier() {
        if (milesBalance >= 50000) {
            this.tier = "Platinum";
            System.out.println(name + " upgraded to Platinum Tier!");
        }
    }
}
