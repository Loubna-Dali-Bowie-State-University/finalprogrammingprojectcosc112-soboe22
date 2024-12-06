import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class EmployeeProj {
    public static void main(String[] args) {
        Scanner scnr;
        scnr = new Scanner(System.in);

        // Ask User For Name
        System.out.print("Enter First And Last Name: ");
        String name = scnr.nextLine();

        System.out.println("Welcome " + name + "!");

        // Ask User For Employee ID
        String employeeId;

        while (true) {
            System.out.println("Please Enter Your 7 Digit Employee ID: ");
            employeeId = scnr.nextLine();

        //Make Sure Employee ID Is Valid
            if (employeeId.matches("\\d{7}")) {
                System.out.println("You Are Checked In.");
                break;
            }else {
                System.out.println("Invalid Employee ID. Please try again.");
            }
        }
        LocalDateTime checkInTime = LocalDateTime.now();
        System.out.println("Check-in time: " + checkInTime);

        while(true) {
            System.out.print("Enter Your Employee ID To Check Out: ");
            String enteredId = scnr.nextLine();

            if (enteredId.equals(employeeId)){
                System.out.println("Welcome Back " + name + "! Checking Out...");
                break;
            }else {
                System.out.println("Employee ID Does Not Match. Please Try Again.");
            }
        }


        LocalDateTime checkOutTime = LocalDateTime.now();
        System.out.println("Check-out Time: " + checkOutTime);

        System.out.println("Enter Your Hourly Pay: ");
        double hourlyPay = scnr.nextDouble();

        //Calculate Shift Duration And Hourly Pay
        Duration shift = Duration.between(checkInTime,checkOutTime);

        double totalPay = hourlyPay * shift.toHours();




        // Generate and display shift report
        System.out.println("\n--- Shift Report ---");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Check-In Time: " + checkInTime);
        System.out.println("Check-Out Time: " + checkOutTime);
        System.out.println("You Worked: " + shift + "Hours.");
        System.out.println("Shift Salary: " + totalPay);

        scnr.close();

        }
    }

