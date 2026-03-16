import java.util.Scanner;

public class VotingSystem {
    public static void main(String[] args) {
        System.out.println("Blockchain based voting System");
        System.out.println("--------------------------------");

        Blockchain votingSystem = new Blockchain(5);

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nPlease select a menu option:");
            System.out.println("1. Cast a vote");
            System.out.println("2. View voting results");
            System.out.println("3. Verify blockchain");
            System.out.println("4. View entire blockchain");
            System.out.println("5. Run simulation (auto voting)");
            System.out.println("0. Exit\n");
            System.out.print("Selection: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter voter ID: ");
                    String voterID = sc.nextLine();
                    System.out.print("Enter candidate Name: ");
                    String candidate = sc.nextLine();
                    votingSystem.addVote(voterID, candidate);
                    break;

                case 2:
                    votingSystem.printResults();
                    break;

                case 3:
                    System.out.println("\nVerifying blockchain...");
                    if (votingSystem.isChainValid()) {
                        System.out.println("✓ The blockchain is valid!");
                    } else {
                        System.out.println("✗ The blockchain has been compromised!");
                    }
                    break;

                case 4:
                    votingSystem.printBlockchain();
                    break;

                case 5:
                    runSimulation(votingSystem);
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }

    private static void runSimulation(Blockchain votingSystem) {
        System.out.println("\nSimulation started...");

        String[] voters = { "V001", "V002", "V003", "V004", "V005", "V006", "V007", "V008" };
        String[] candidates = { "C1", "C2", "C3" };

        System.out.println(voters.length + "voters will vote.\n");

        for (String voter : voters) {
            String candidate = candidates[(int)(Math.random() * candidates.length)];
            votingSystem.addVote(voter, candidate);
        }

        System.out.println("\nSimulation done.");
        votingSystem.printResults();

        System.out.println("\nVerifying blockchain integrity...");
        if (votingSystem.isChainValid()) {
            System.out.println("✓ Blockchain integrity verified. All votes are secure.");
        }

    }
}
