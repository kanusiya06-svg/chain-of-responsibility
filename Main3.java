/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pattern;
class LoanRequest {
    String customerName;
    double loanAmount;

    LoanRequest(String name, double amount) {
        customerName = name;
        loanAmount = amount;
    }
}

abstract class LoanApprover {
    LoanApprover nextApprover;

    void setNext(LoanApprover next) {
        nextApprover = next;
    }

    abstract boolean canApprove(double amount);

    abstract String getName();

    void approve(LoanRequest request) {

        if (canApprove(request.loanAmount)) {

            System.out.println("Loan Approved");
            System.out.println();
            System.out.println("Customer Name : " +
                    request.customerName);
            System.out.println("Approved By : " +
                    getName());
            System.out.println("Loan Amount : " +
                    request.loanAmount);
            System.out.println("Approval Status : Approved");

        } else if (nextApprover != null) {

            nextApprover.approve(request);

        } else {

            System.out.println("Loan Rejected");
        }
    }
}

class LoanOfficer extends LoanApprover {

    boolean canApprove(double amount) {
        return amount <= 50000;
    }

    String getName() {
        return "Loan Officer";
    }
}

class BranchManager extends LoanApprover {

    boolean canApprove(double amount) {
        return amount > 50000 && amount <= 500000;
    }

    String getName() {
        return "Branch Manager";
    }
}

class RegionalManager extends LoanApprover {

    boolean canApprove(double amount) {
        return amount > 500000;
    }

    String getName() {
        return "Regional Manager";
    }
}

public class Main3 {

    public static void main(String[] args) {

        LoanApprover officer = new LoanOfficer();
        LoanApprover branch = new BranchManager();
        LoanApprover regional = new RegionalManager();

        officer.setNext(branch);
        branch.setNext(regional);

        LoanRequest request =
                new LoanRequest("Prasanth", 300000);

        officer.approve(request);
    }
}

