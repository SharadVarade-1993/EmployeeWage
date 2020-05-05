class CompanyEmpWage {

          public static final int isFullTime=1;
          public static final int isPartTime=2;


          private final String company;
          private final int empRatePerHour;
          private final int numOfworkingDays;
	  private final int maxHrsInMonth;

	   public CompanyEmpWage (String company,int empRatePerHour,int numOfworkingDays,int maxHrsInMonth)
	   {
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.numOfworkingDays=numOfworkingDays;
		this.maxHrsInMonth=maxHrsInMonth;
	   }
	      static int empHrs=0;
	      static int empWage=0;

	  static int randomCheck()
	  {
             int empCheck=(int)Math.floor(Math.random()* 10) % 3;
             return empCheck;
	  }
	  static void employeePresenceCheck()
	  {
             int  empCheck=randomCheck();
             if(empCheck==isFullTime || empCheck==isPartTime)
                    System.out.println("Employee is Present");
             else
                    System.out.println("Employee is Absent");
	   }
	   static int getWorkHours(){
		   int empCheck=randomCheck();
                        switch (empCheck){
                           case isFullTime:
                               empHrs=8;  
                               break;
	                   case isPartTime:
	                       empHrs=4;
	                       break;
	                   default:
	                       empHrs=0;
	               }
		return empHrs;
	   }

	    public void computeEmpWage() 
	    {
		   int totalEmpHrs=0,totalWorkingDays=0,totalEmpWage=0;
	           while (totalEmpHrs <=maxHrsInMonth && totalWorkingDays<numOfworkingDays)
		       {
                           totalWorkingDays++;
			   int empHrs=getWorkHours();
	                   empWage=empHrs*empRatePerHour;
		       	   totalEmpHrs+=empHrs;
			   System.out.println("Day#:"+totalWorkingDays+"Emp Hr : " +empHrs );
                           totalEmpWage+=empWage;

		       }
		       System.out.println("Total Emp Wage for Company:"+company+" is :"+totalEmpWage);
		}
 }


public class EmployeeWage
{
	private int numOfCompany=0;
	private CompanyEmpWage [] companyEmpWageArray;

	public void EmployeeWageArray(){
		companyEmpWageArray=new CompanyEmpWage[5];
	}

	public void addCompanyEmpWage(String company,int maxHrsInMonth,int empRatePerHour,int numOfWorkingDays){
		companyEmpWageArray[numOfCompany]=new CompanyEmpWage(company,maxHrsInMonth,empRatePerHour,numOfWorkingDays);
		numOfCompany++;
	}
	public void computeEmpWage(){
		for(int i=0;i< numOfCompany;i++){
			companyEmpWageArray[i].computeEmpWage();
		}
	}
    public static void main(String[] args){
        EmployeeWage emp=new EmployeeWage();
		emp.EmployeeWageArray();
		emp.addCompanyEmpWage("DMart",20,10,2);
		emp.addCompanyEmpWage("BridgeLabz",20,10,2);
		emp.addCompanyEmpWage("WellMart",20,3,20);
		emp.addCompanyEmpWage("BigBasket",20,2,10);
		emp.addCompanyEmpWage("BigBazaar",20,4,20);
		emp.computeEmpWage();
    }
}
