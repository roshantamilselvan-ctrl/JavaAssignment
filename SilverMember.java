package JavaProject;

public class SilverMember extends Member {
    public SilverMember(String memberId, String name, String email) {
        super(memberId, name, email);
        this.tier = "Silver";
    }

    @Override
    public double getBonusMultiplier() { return 1.0; }

    @Override
    public void evaluateTier() {
        if (milesBalance >= 25000) {
            this.tier = "Gold";
            System.out.println(name + " upgraded to Gold Tier!");
        }
    }
}
