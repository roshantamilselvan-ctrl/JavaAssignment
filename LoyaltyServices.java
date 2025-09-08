package JavaProject;
import java.util.*;

public class LoyaltyServices {
    private List<Member> members = new ArrayList<>();
    private List<Reward> rewards = new ArrayList<>();

    public Member enrollMember(String memberId, String name, String email) {
        Member member = new SilverMember(memberId, name, email);
        members.add(member);
        System.out.println("Enrolled Member: " + name);
        return member;
    }

    public void addReward(Reward reward) {
        rewards.add(reward);
    }

    public void creditMiles(Member member, FlightActivity activity) {
        member.creditMiles(activity.getDistance(), activity.getFareClass());
        member.evaluateTier();
        activity.setMilesEarned(activity.getDistance());
        System.out.println("Miles credited for " + member.getName());
    }

    public void redeemReward(Member member, String rewardName) {
        for (Reward r : rewards) {
            if (r.getName().equalsIgnoreCase(rewardName)) {
                r.redeem(member);
                return;
            }
        }
        System.out.println("Reward not found.");
    }

    public void printAllMembers() {
        for (Member m : members) {
            m.printStatement();
        }
    }

    public void printTierSummary() {
        long silver = members.stream().filter(m -> m.getTier().equals("Silver")).count();
        long gold = members.stream().filter(m -> m.getTier().equals("Gold")).count();
        long platinum = members.stream().filter(m -> m.getTier().equals("Platinum")).count();
        System.out.println("Tier Summary: Silver=" + silver + ", Gold=" + gold + ", Platinum=" + platinum);
    }
}
