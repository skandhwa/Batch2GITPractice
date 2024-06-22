package POJOMapper;

public class CreateUser {
	
	
	public static  Object createUser()
	{
	
	
	CreateUserPOJO emp=new CreateUserPOJO();
	emp.setUsername("Harish");
	emp.setAddress("Kolkata");
	emp.setId(1234);
	emp.setSalary(56000f);
	
	return emp;
	
	
	
	
	}
	

}
