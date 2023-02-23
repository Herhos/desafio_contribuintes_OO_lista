package entities;

public class TaxPayer
{
	private double salaryIncome;
	private double serviceIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	double aliquot = 0.00;
	
	public TaxPayer(double salaryIncome, double serviceIncome, double capitalIncome, double healthSpending,
			double educationSpending)
	{
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}	

	public double getSalaryIncome()
	{
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome)
	{
		this.salaryIncome = salaryIncome;
	}

	public double getServiceIncome()
	{
		return serviceIncome;
	}

	public void setServiceIncome(double serviceIncome)
	{
		this.serviceIncome = serviceIncome;
	}

	public double getCapitalIncome()
	{
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome)
	{
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending()
	{
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending)
	{
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending()
	{
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending)
	{
		this.educationSpending = educationSpending;
	}		

	public double salaryTax(double salary)
	{
		if (salary < 36000.00)
		{
			aliquot = 0;
		}
		else if (salary < 60000.00)
		{
			aliquot = 10;
		}
		else
		{
			aliquot = 20;
		}
		return salary * (aliquot / 100); 
	}
	
	public double servicesTax(double service)
	{
		return getServiceIncome() * (15.00 / 100);
	}
	
	public double capitalTax(double capital)
	{
		return getCapitalIncome() * (20.00 / 100);
	}
	
	public double deductionSpending(double health, double education)
	{
		return healthSpending + educationSpending;
	}	
	
	public double grossTax()
	{
		return salaryTax(salaryIncome) + servicesTax(serviceIncome) + capitalTax(capitalIncome);
	}
	
	public double maxDeduction(double grossTax)
	{
		return grossTax * 30.00 / 100;
	}
	
	public double taxRebate()
	{
		if (deductionSpending(healthSpending, educationSpending) < maxDeduction(grossTax()))
		{
			return deductionSpending(healthSpending, educationSpending);
		}
		else
		{			
			return maxDeduction(grossTax());
		}		
	}
	
	public double netTax()
	{
		return grossTax() - taxRebate();
	}

	@Override
	public String toString()
	{
		return "TaxPayer [salaryIncome=" + salaryIncome + ", serviceIncome=" + serviceIncome + ", capitalIncome="
				+ capitalIncome + ", healthSpending=" + healthSpending + ", educationSpending=" + educationSpending + "]";
	}	
}
