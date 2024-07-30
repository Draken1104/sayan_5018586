//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// DecoratorPatternExample.java

// Step 1: Define Component Interface
interface Notifier {
    void send(String message);
}

// Step 2: Implement Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email with message: " + message);
    }
}

// Step 3: Implement Decorator Classes
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

// Step 4: Test the Decorator Implementation
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create a simple email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Wrap it with SMS notifier
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Wrap it with Slack notifier
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notification via Email, SMS, and Slack
        slackNotifier.send("Hello, this is a test notification!");
    }
}
