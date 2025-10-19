package telecombilling;

public class TelecomBilling {
    public static void main(String[] args) {
        // Initial airtime load
        double airtimeLoaded = 10000.0;

        // Step 1: Deduct 10% loading fee
        double loadingFee = 0.10 * airtimeLoaded;
        double balanceAfterFee = airtimeLoaded - loadingFee;

        // Step 2: Call details
        int callDurationMinutes = 5;
        int callDurationSeconds = callDurationMinutes * 60;
        int costPerSecond = 200;
        int totalCallCost = callDurationSeconds * costPerSecond;

        // Step 3: Check if balance is sufficient
        if (balanceAfterFee >= totalCallCost) {
            double finalBalance = balanceAfterFee - totalCallCost;

            System.out.println("Initial Airtime Loaded: UGX " + airtimeLoaded);
            System.out.println("Loading Fee (10%): UGX " + loadingFee);
            System.out.println("Balance after Fee: UGX " + balanceAfterFee);
            System.out.println("Call Duration: " + callDurationMinutes + " minutes (" + callDurationSeconds + " seconds)");
            System.out.println("Call Cost: UGX " + totalCallCost);
            System.out.println("Final Balance: UGX " + finalBalance);
        } else {
            System.out.println("Insufficient balance to make a " + callDurationMinutes + "-minute call.");
            System.out.println("Required: UGX " + totalCallCost + ", Available: UGX " + balanceAfterFee);
        }
    }
}
