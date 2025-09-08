package JavaProject;

public class PlatinumMember extends Member {
    public PlatinumMember(String memberId, String name, String email) {
        super(memberId, name, email);
        this.tier = "Platinum";
    }

    @Override
    public double getBonusMultiplier() { return 1.5; }

    @Override
    public void evaluateTier() {
        // Platinum is the highest
        System.out.println(name + " is already Platinum!");
    }
}
