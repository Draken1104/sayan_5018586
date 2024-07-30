//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// AdapterPatternExample.java

// Step 1: Define Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step 2: Implement Adaptee Classes
class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

class Stripe {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

class Square {
    public void performPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Square.");
    }
}

// Step 3: Implement the Adapter Class
class PayPalAdapter implements PaymentProcessor {
    private final PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private final Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.sendPayment(amount);
    }
}

class SquareAdapter implements PaymentProcessor {
    private final Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void processPayment(double amount) {
        square.performPayment(amount);
    }
}

// Step 4: Test the Adapter Implementation
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Create instances of the different payment gateways
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();
        Square square = new Square();

        // Create adapter instances for the payment gateways
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        PaymentProcessor squareAdapter = new SquareAdapter(square);

        // Process payments through the adapters
        payPalAdapter.processPayment(100.00);
        stripeAdapter.processPayment(200.00);
        squareAdapter.processPayment(300.00);
    }
}
