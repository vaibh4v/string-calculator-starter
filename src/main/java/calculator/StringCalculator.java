package calculator;

class StringCalculator
{
    public int add(String input)
    {
    	if(input.isEmpty())
    	{
    		// returning 0 if string is empty
    		return 0;
    	}
    	else if(input.contains(","))
    	{
    		String[] tokens = input.split(",");
    		
    		int sum = 0;
    		
    		for(String num : tokens)
    		{
    			sum += Integer.parseInt(num);
    		}
    		
    		return sum;
    	}
    	else
    	{
    		return Integer.parseInt(input);
    	}
    }
}