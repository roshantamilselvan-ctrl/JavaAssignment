package JavaProject;

public abstract class Member {
    protected String memberId;
    protected String name;
    protected String email;
    protected String tier;
    protected int milesBalance;

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.tier = "Silver"; // default
        this.milesBalance = 0;
    }

    // Getters and Setters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getTier() { return tier; }
    public int getMilesBalance() { return milesBalance; }

    public void setMilesBalance(int miles) { this.milesBalance = miles; }

    // Credit miles - Method Overloading
    public void creditMiles(int distance) {
        this.milesBalance += (int)(distance * getBonusMultiplier());
    }

    public void creditMiles(int distance, String fareClass) {
        double multiplier = fareClass.equalsIgnoreCase("Business") ? 1.5 : 1.0;
        this.milesBalance += (int)(distance * multiplier * getBonusMultiplier());
    }

    // Abstract methods for tier-specific logic
    public abstract double getBonusMultiplier();
    public abstract void evaluateTier();

    // Statement
    public void printStatement() {
        System.out.println("==== Member Statement ====");
        System.out.println("ID: " + memberId + " | Name: " + name + " | Tier: " + tier);
        System.out.println("Miles Balance: " + milesBalance);
    }
}

