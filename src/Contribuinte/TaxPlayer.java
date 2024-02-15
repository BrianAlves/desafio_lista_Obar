package Contribuinte;

public class TaxPlayer {
   private double salaryIncome;
   private double servicesIncome;
   private double capitalIncome;
   private double healthSpending;
   private double educationSpending;

   public TaxPlayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
         double educationSpending) {
      this.salaryIncome = salaryIncome;
      this.servicesIncome = servicesIncome;
      this.capitalIncome = capitalIncome;
      this.healthSpending = healthSpending;
      this.educationSpending = educationSpending;
   }

   public double salaryTax() {
      double netSalary = salaryIncome / 12.0;
      if (netSalary >= 5000.00)
         return salaryIncome * 0.2;
      else if (netSalary >= 3000.00)
         return salaryIncome * 0.1;
      else
         return netSalary;
   }

   public double servicesTax() {
      return servicesIncome * 0.15;
   }

   public double capitalTax() {
      return capitalIncome * 0.2;
   }

   public double grossTax() {
      return salaryTax() + servicesTax() + capitalTax();
   }

   public double taxRebate() {
      return grossTax() - netTax();
   }

   public double netTax() {
      double total = educationSpending + healthSpending;
      return total < grossTax() * 0.3 ? total : grossTax() * 0.3;
   }
}