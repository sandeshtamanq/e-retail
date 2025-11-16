# Order Processing Demo

## Overview
This project demonstrates a basic order processing system using Java. It includes functionalities for managing products, customers, orders, and payment processing. The system supports different payment strategies, such as card payments and wallet payments.

## Project Structure
```
OrderProcessingDemo
├── pom.xml
├── .gitignore
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── demo
│   │   │   │   └── DemoMain.java
│   │   │   ├── model
│   │   │   │   ├── Product.java
│   │   │   │   ├── Customer.java
│   │   │   │   ├── Order.java
│   │   │   │   └── OrderItem.java
│   │   │   ├── payments
│   │   │   │   ├── PaymentStrategy.java
│   │   │   │   ├── CardPayment.java
│   │   │   │   └── WalletPayment.java
│   │   │   ├── inventory
│   │   │   │   └── InventoryService.java
│   │   │   ├── notifications
│   │   │   │   └── NotificationService.java
│   │   │   └── services
│   │   │       └── OrderProcessor.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── demo
│               └── DemoMainTest.java
```

## Setup Instructions
1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd OrderProcessingDemo
   ```

2. **Build the Project**
   Ensure you have Maven installed. Run the following command to build the project:
   ```bash
   mvn clean install
   ```

3. **Run the Application**
   You can run the application using the following command:
   ```bash
   mvn exec:java -Dexec.mainClass="demo.DemoMain"
   ```

## Usage
- The application initializes an inventory service and an order processor.
- It creates products and adds them to the inventory.
- Customers can place orders using different payment methods.
- The order processing system notifies observers about the order status.

## Contributing
Feel free to fork the repository and submit pull requests for any improvements or features you would like to add.

## License
This project is licensed under the MIT License. See the LICENSE file for details.