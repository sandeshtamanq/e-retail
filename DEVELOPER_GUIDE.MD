# Developer Guide

## Overview
This document serves as a guide for developers working on the Order Processing Demo project. It provides a mapping of UML classes to their corresponding Java files, ensuring clarity in the project's structure and design.

## UML Class Mapping

| UML Class Name         | Java File Path                                   |
|------------------------|--------------------------------------------------|
| DemoMain               | src/main/java/demo/DemoMain.java                |
| Product                | src/main/java/model/Product.java                 |
| Customer               | src/main/java/model/Customer.java                |
| Order                  | src/main/java/model/Order.java                   |
| OrderItem              | src/main/java/model/OrderItem.java               |
| PaymentStrategy        | src/main/java/payments/PaymentStrategy.java      |
| CardPayment            | src/main/java/payments/CardPayment.java          |
| WalletPayment          | src/main/java/payments/WalletPayment.java        |
| InventoryService       | src/main/java/inventory/InventoryService.java    |
| NotificationService    | src/main/java/notifications/NotificationService.java |
| OrderProcessor         | src/main/java/services/OrderProcessor.java       |

## Additional Notes
- Ensure that all Java files are properly organized within their respective packages as indicated in the table above.
- Follow coding standards and conventions for naming and structuring classes and methods.
- Maintain clear and concise documentation within each Java file to facilitate understanding and collaboration among developers.

## Conclusion
This guide should help developers navigate the project structure and understand the relationships between different components. For any further questions or clarifications, please refer to the README.md or reach out to the project maintainers.