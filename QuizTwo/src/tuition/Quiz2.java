package tuition;

import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class Quiz2 {
	private double term;
	private double tuitionCost;
	private double Increase;
	private double APR;

	
	public void setTerm(double term)
	{
		this.term = term;
	}
	public double getTerm()
	{
		return term;
	}
	public void setTuitionCost(double tuitionCost)
	{
		this.tuitionCost = tuitionCost;
	}
	public double getTuitionCost()
	{
		return tuitionCost;
	}
	public void setIncrease(double Increase)
	{
		this.Increase = Increase;
	}
	public double getIncrease()
	{
		return Increase;
	}
	public void setAPR(double APR)
	{
		this.APR = APR;
	}
	public double getAPR()
	{
		return APR;
	}
	

	
	public void TuitionVariables(double term, double tuitionCost, double Increase, double APR)
	{
	
		this.term = term;
		this.tuitionCost = tuitionCost;
		this.Increase = Increase;
		this.APR = APR;
	}
	
	public double getTuitionTotal(double t, double rate) {
		double increase = t * rate;
		for (int i = 0; i<3; i++){
			t += increase;
			increase = increase * rate;
			
		}
		return t;
	}

	public static void main(String[] args) {
		
	double sc;
	Scanner scanner = new Scanner(System.in);
	TuitionVariables tuition = new TuitionVariables();
	
		
	System.out.println("Please enter the cost of tuition: ");
	sc = scanner.nextDouble();
	tuition.setTuitionCost(sc);
	
	
	System.out.println("Enter how much tuition increased (decimal): ");
	sc = scanner.nextDouble();
	sc = 1 + (sc / 100);
	tuition.setPercentIncrease(sc);
	
	
	System.out.println("What is the repayment APR?: ");
	sc = scanner.nextDouble();
	sc = sc / 100;
	tuition.setAPR(sc);
	
	
	System.out.println("Please enter how long it will take to pay back: ");
	sc = scanner.nextDouble();
	tuition.setTerm(sc);
	
	double total;
	total = tuition.getTuitionTotal(tuition.getTuitionCost(), tuition.getIncrease());
	
	double FV; 
	
	FV = FinanceLib.fv(tuition.getAPR(), tuition.getTerm(), 0, total, true);
	FV *= -1;
	
	double monthly;
	monthly = FV / (tuition.getTerm() * 6);
	
	
	}
}
