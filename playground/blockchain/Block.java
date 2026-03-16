import java.security.MessageDigest;
import java.util.Date;

public class Block {
    private int index;
    private long timestamp;
    private String vote;
    private String previousHash;
    private String hash;
    private int nonce;

    public Block(int index, String vote, String previousHash) {
        this.index = index;
        this.vote = vote;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.nonce = 0;
        this.hash = calculateHash();
    }

    /**
     * SHA-256 알고리즘 활용 해시 값 생성
     *
     * @return Hash value
     */
    public String calculateHash() {
        try {
            String data = index + timestamp + vote + previousHash + nonce;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(data.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) sb.append('0');
                sb.append(hex);
            }

            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("exception occurs: " + e.getMessage());
        }
    }

    /**
     * Proof of Work, 간단한 작업 증명
     *
     * @param difficulty 작업 증명의 난이도 값
     */
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!this.hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }

        System.out.println("### block mine clear.");
    }

    /**
     * Getters
     */
    public int getIndex() { return index; }
    public long getTimestamp() { return timestamp; }
    public String getVote() { return vote; }
    public String getPreviousHash() { return previousHash; }
    public String getHash() { return hash; }

    @Override
    public String toString() {
        return "Block #" + this.index + "\n" +
                "Timestamp: " + new Date(this.timestamp) + "\n" +
                "Vote: " + this.vote + "\n" +
                "Previous Hash: " + this.previousHash + "\n" +
                "Hash: " + this.hash + "\n";
    }
}