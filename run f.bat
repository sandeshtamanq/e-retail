@echo off
REM This script compiles and runs the Order Processing Demo application

REM Set the Java source directory
set SRC_DIR=src\main\java

REM Set the classpath to include the source directory
set CLASSPATH=%SRC_DIR%

REM Compile the Java files
javac %SRC_DIR%\demo\DemoMain.java %SRC_DIR%\model\Product.java %SRC_DIR%\model\Customer.java %SRC_DIR%\model\Order.java %SRC_DIR%\model\OrderItem.java %SRC_DIR%\payments\PaymentStrategy.java %SRC_DIR%\payments\CardPayment.java %SRC_DIR%\payments\WalletPayment.java %SRC_DIR%\inventory\InventoryService.java %SRC_DIR%\notifications\NotificationService.java %SRC_DIR%\services\OrderProcessor.java

REM Run the application
java demo.DemoMain

pause