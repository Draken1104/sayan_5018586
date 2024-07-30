//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// ObserverPatternExample.java

import java.util.ArrayList;
import java.util.List;

// Step 1: Define Subject Interface
interface Stock {

}

// Step 2: Implement Concrete Subject
class StockMarket implements Stock {
    private final List<Observer> observers;
    private final String stockName;
    private double stockPrice;

    public StockMarket(String stockName) {
        this.stockName = stockName;
        this.observers = new ArrayList<>();
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }



    public void registerObserver(Observer observer) {
        observers.add(observer);
    }


    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }


    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }
}

// Step 3: Define Observer Interface
interface Observer {
    void update(String stockName, double stockPrice);
}

// Step 4: Implement Concrete Observers
class MobileApp implements Observer {
    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(appName + " received update: " + stockName + " is now $" + stockPrice);
    }
}

class WebApp implements Observer {
    private final String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(appName + " received update: " + stockName + " is now $" + stockPrice);
    }
}

// Step 5: Test the Observer Implementation
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create stock market subject
        StockMarket appleStock = new StockMarket("Apple");

        // Create observers
        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        // Register observers
        appleStock.registerObserver(mobileApp);
        appleStock.registerObserver(webApp);

        // Update stock price
        appleStock.setStockPrice(150.00);
        appleStock.setStockPrice(155.50);

        // Deregister an observer
        appleStock.deregisterObserver(mobileApp);

        // Update stock price
        appleStock.setStockPrice(160.75);
    }
}
