package Pack;

public class TestingTest {
	public static void main(String[] args) {
    	// Making my scanner for the Stringbuilder 
		
		int testInt1 = 0;
		int testInt2 = 5;
		
		String testString1 = "testString1";
		
        StringBuilder string1 = new StringBuilder(
        		"Hey there " + "Compute name will go here" + "\n");
        
        if (testInt1 == 0) {
        	string1.append("The if");
        	System.out.println("var1: " + string1);
        }
        else {
        	string1.append("The else");
        	System.out.println("Test: " + string1);
        }
	}

}
