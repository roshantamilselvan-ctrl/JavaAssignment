package JavaProject;

public class LoyaltyAppMain {
    public static void main(String[] args) {
        LoyaltyServices service = new LoyaltyServices();

        // Enroll members
        Member m1 = service.enrollMember("M001", "Alice", "alice@email.com");
        Member m2 = service.enrollMember("M002", "Bob", "bob@email.com");
        // Add rewards
        service.addReward(new Reward("R001", "Free Flight", 20000, 2));
        service.addReward(new Reward("R002", "Upgrade Voucher", 15000, 5));
        service.addReward(new Reward("R003", "Shopping Voucher", 5000, 10));

        // Flight Activities
        FlightActivity f1 = new FlightActivity("A001", "AI101", "2025-09-07", 12000, "Economy");
        FlightActivity f2 = new FlightActivity("A002", "AI202", "2025-09-08", 15000, "Business");

        service.creditMiles(m1, f1);
        service.creditMiles(m1, f2);

        // Redeem
        service.redeemReward(m1, "Shopping Voucher");
        service.redeemReward(m1, "Free Flight");

        // Print Statements
        service.printAllMembers();
        service.printTierSummary();
    }
}
