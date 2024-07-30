//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        // Base case: if no more periods left, return the initial value
        if (periods == 0) {
            return initialValue;
        }
        // Recursive case: calculate the future value for the next period
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, periods - 1);
    }

    // Optimized method using memoization
    public static double calculateFutureValueMemoized(double initialValue, double growthRate, int periods, double[] memo) {
        // Base case: if no more periods left, return the initial value
        if (periods == 0) {
            return initialValue;
        }
        // Check if the value is already computed
        if (memo[periods] != 0) {
            return memo[periods];
        }
        // Recursive case: calculate the future value for the next period
        memo[periods] = calculateFutureValueMemoized(initialValue * (1 + growthRate), growthRate, periods - 1, memo);
        return memo[periods];
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial value
        double growthRate = 0.05;     // 5% growth rate
        int periods = 10;             // Number of periods (e.g., years)

        // Calculate future value using simple recursion
        double futureValue = calculateFutureValue(initialValue, growthRate, periods);
        System.out.println("Future Value (Recursive): " + futureValue);
        // Calculate future value using memoization
        double[] memo = new double[periods + 1]; // Memoization array
        double futureValueMemoized = calculateFutureValueMemoized(initialValue, growthRate, periods, memo);
        System.out.println("Future Value (Memoized): " + futureValueMemoized);
    }
}
