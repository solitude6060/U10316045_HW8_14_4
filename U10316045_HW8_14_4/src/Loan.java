//homework about Loan and IllegalArgumentException
//U10316045
//2015.05.18

public class Loan{
	//main class
	public static void main(String[] args) {
		//try catch
		try {
			new NewLoan(5.5, 10, 100000);
			//wrong test
			NewLoan Loa = new NewLoan(-1, 3, 3);
			new NewLoan(5.5, 10, 20000);
		}
		catch (Exception ex) {//for all exception
			System.out.println(ex);
		}

		System.out.println("End of program");
	}
}

class NewLoan {
	private double annualInterestRate;
	private int numOfYears;
	private double loanAmount;

	/** Default constructor */
	public NewLoan() {
		this(5.5, 10, 100000);
	}

	/** Construct a NewLoan with specified annual interest rate,
      	number of years and loan amount
	 */
	public NewLoan(double annualInterestRate, int numOfYears,double loanAmount) {
		
		if (annualInterestRate <= 0){
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		}
		
		if (numOfYears <= 0){
			throw new IllegalArgumentException("Number of years must be positive.");
		}
		
		if (loanAmount <= 0){
			throw new IllegalArgumentException("Loan amount must be positive.");
		}
		
		setAnnualInterestRate(annualInterestRate);
		setNumOfYears(numOfYears);
		setLoanAmount(loanAmount);
	}

	// get annualInterestRate 
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	// Set  annualInterestRate 
	public void setAnnualInterestRate(double annualInterestRate) {
		if (annualInterestRate <= 0){
			throw new IllegalArgumentException("Annual interest rates must be positive.");
		}
		this.annualInterestRate = annualInterestRate;
	}

	// get numOfYears 
	public int getNumOfYears() {
		return numOfYears;
	}

	// Set  numOfYears
	public void setNumOfYears(int numOfYears) {
		if (numOfYears <= 0){
			throw new IllegalArgumentException("Number of years must be positive.");
		}
		this.numOfYears = numOfYears;
	}

	//get loanAmount 
	public double getLoanAmount() {
		return loanAmount;
	}

	//Set loanAmount 
	public void setLoanAmount(double loanAmount) {
		if (loanAmount <= 0){
			throw new IllegalArgumentException("Loan amount must be positive.");
		}
		this.loanAmount = loanAmount;
	}

	//get monthlypayment 
	public double monthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		return loanAmount * monthlyInterestRate / (1 -(Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
	}

	//get totalpayment
	public double totalPayment() {
		return monthlyPayment() * numOfYears * 12;
	}
}
