import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Blockchain {
    private ArrayList<Block> blockchain;
    private int difficulty;

    public Blockchain(int difficulty) {
        this.blockchain = new ArrayList<>();
        this.difficulty = difficulty;

        // Genesis Block Generate
        blockchain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {
        Block genesis = new Block(0, "Genesis Block", "0");
        genesis.mineBlock(difficulty);
        return genesis;
    }

    public Block getLatestBlock() {
        return blockchain.getLast();
    }

    public void addVote(String voterId, String candidate) {
        String voteData = "voter: " + voterId + " -> candidate: " + candidate;
        Block newBlock = new Block(
                blockchain.size(),
                voteData,
                getLatestBlock().getHash()
        );

        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
        System.out.println("### The vote has been recorded on the blockchain.");
    }

    public boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("### The hash of block #" + i + " is invalid.");
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("### The chain connection of block #" + i + " is broken.");
                return false;
            }
        }

        return true;
    }

    public Map<String, Integer> tallyVotes() {
        Map<String, Integer> results = new HashMap<>();

        for (int i = 1; i < blockchain.size(); i++) {
            String voteData = blockchain.get(i).getVote();

            if (voteData.contains("candidate:")) {
                String candidate = voteData.split("candidate:")[1].trim();
                results.put(candidate, results.getOrDefault(candidate, 0) + 1);
            }
        }

        return results;
    }

    public void printBlockchain() {
        System.out.println("--------------blockchain--------------");
        for (Block block : blockchain) {
            System.out.println(block);
            System.out.println("--------------------------------------");
        }
    }

    public void printResults() {
        System.out.println("----------------output----------------");
        Map<String, Integer> results = tallyVotes();

        if (results.isEmpty()) {
            System.out.println("### There are no votes yet.");

            return;
        }

        results.forEach((candidate, votes) ->
                System.out.println(candidate + ": " + votes)
        );

        System.out.println("### Total number of votes: " + (blockchain.size() - 1));
        System.out.println("--------------------------------------");
    }

    public int getBlockchainSize() {
        return blockchain.size();
    }
}
