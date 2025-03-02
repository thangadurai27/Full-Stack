package transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
public class Transaction {
    private int fromAccountId;
    private int toAccountId;
    private int transactionId;
    private double amount;
    private String date;
    private String transactionType;
    private Connection dbConnection;  // Database connection

    // Constructor with database connection
    public Transaction(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    // Default constructor for transaction entries
    public Transaction(int transactionId, int fromAccountId, int toAccountId, double amount, String date, String transactionType) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.date = date;
        this.transactionType = transactionType;
    }

    // Getters and Setters
    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getTransactionAccount() {
        return amount;
    }

    public void setTransactionAccount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    // Method to add a transaction to the transaction_history table
    public void addTransaction(long fromAcc, long toAcc, String type, double amount) {
        try {
            String query = "INSERT INTO transactionhistory (type, from_acc, to_acc, amount, time) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = dbConnection.prepareStatement(query);
            pstmt.setString(1, type);
            pstmt.setLong(2, fromAcc);
            pstmt.setLong(3, toAcc);
            pstmt.setDouble(4, amount);
            pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));  // Current timestamp
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Method to fetch transaction history for a specified account
    public ArrayList<Transaction> getTransactionHistory(long accountNumber) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        
        try {
            String query = "SELECT transactionid, type, from_acc, to_acc, amount, time FROM transactionhistory WHERE from_acc = ? OR to_acc = ?";
            PreparedStatement pstmt = dbConnection.prepareStatement(query);
            pstmt.setLong(1, accountNumber);
            pstmt.setLong(2, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction(dbConnection);
                transaction.setTransactionId(rs.getInt("transactionid"));
                transaction.setTransactionType(rs.getString("type"));
                transaction.setFromAccountId(rs.getInt("from_acc"));
                transaction.setToAccountId(rs.getInt("to_acc"));
                transaction.setTransactionAccount(rs.getDouble("amount"));
                transaction.setDate(rs.getTimestamp("time").toString());

                transactions.add(transaction);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    // Update balance for a given account in the database
    public void updateAccountBalance(long accountNumber, double newBalance) {
        try {
            String query = "UPDATE account SET balance = ? WHERE accid = ?";
            PreparedStatement pstmt = dbConnection.prepareStatement(query);
            pstmt.setDouble(1, newBalance);
            pstmt.setLong(2, accountNumber);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve the current balance for a specified account
    public double getAccountBalance(long accountNumber) {
        double balance = 0.0;
        try {
            String query = "SELECT balance FROM account WHERE accid = ?";
            PreparedStatement pstmt = dbConnection.prepareStatement(query);
            pstmt.setLong(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                balance = rs.getDouble("balance");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }
}
