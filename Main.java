package babyfeeding;  // or your package name

import org.apache.commons.lang3.time.DurationFormatUtils;

public class Main {
    // ANSI escape codes for colors and reset
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String CYAN = "\033[36m";
    public static final String YELLOW = "\033[33m";
    public static final String PURPLE = "\033[35m";
    public static final String WHITE_BOLD = "\033[1;37m";

    public static void main(String[] args) {
        double porridgeLiters = 2.0;
        double milkLiters = 2.0;
        double cupSizeLiters = 0.5;  // half liter per cup
        
        // Number of servings
        int porridgeServings = (int)(porridgeLiters / (cupSizeLiters / 2)); // half cup servings
        int milkServings = (int)(milkLiters / cupSizeLiters);               // full cup servings
        
        // Time per serving in minutes
        int porridgeTimePerServing = 45;
        int milkTimePerServing = 30;
        
        // Total time to finish each in minutes
        int totalPorridgeTime = porridgeServings * porridgeTimePerServing;
        int totalMilkTime = milkServings * milkTimePerServing;
        
        int totalTimeMinutes = totalPorridgeTime + totalMilkTime;

        // Convert total time from minutes to milliseconds
        long totalPorridgeMillis = totalPorridgeTime * 60L * 1000L;
        long totalMilkMillis = totalMilkTime * 60L * 1000L;
        long totalTimeMillis = totalTimeMinutes * 60L * 1000L;

        // Format the durations
        String formattedPorridgeTime = DurationFormatUtils.formatDuration(totalPorridgeMillis, "HH:mm:ss");
        String formattedMilkTime = DurationFormatUtils.formatDuration(totalMilkMillis, "HH:mm:ss");
        String formattedTotalTime = DurationFormatUtils.formatDuration(totalTimeMillis, "HH:mm:ss");

        // Print table header with color
        System.out.println(PURPLE + "+----------------------+-----------------+-----------------+" + RESET);
        System.out.println(PURPLE + "|       " + WHITE_BOLD + "Item" + PURPLE + "          | " + WHITE_BOLD + "Total Time" + PURPLE + "     | " + WHITE_BOLD + "Servings" + PURPLE + "       |" + RESET);
        System.out.println(PURPLE + "+----------------------+-----------------+-----------------+" + RESET);

        // Print rows with colors
        System.out.printf("| %-20s | %-15s | %-15d |\n", CYAN + "Porridge (Half cup)" + RESET, YELLOW + formattedPorridgeTime + RESET, porridgeServings);
        System.out.printf("| %-20s | %-15s | %-15d |\n", CYAN + "Milk (Full cup)" + RESET, YELLOW + formattedMilkTime + RESET, milkServings);
        System.out.println(PURPLE + "+----------------------+-----------------+-----------------+" + RESET);
        System.out.printf("| %-20s | %-15s | %-15s |\n", GREEN + "TOTAL" + RESET, GREEN + formattedTotalTime + RESET, GREEN + (porridgeServings + milkServings) + RESET);
        System.out.println(PURPLE + "+----------------------+-----------------+-----------------+" + RESET);
    }
}
