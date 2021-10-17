package calculator;

class StringCalculator
{
	public int add(String inputString)
	{
		String inputWithoutDelimiterInfo = inputString;
		
		String delimiter = ",|\n";
		
		if(inputString.startsWith("//"))
		{
			delimiter = inputString.substring(2, 3);
			
			delimiter = delimiter.concat("|\n");
			
			inputWithoutDelimiterInfo = inputString.substring(4);
		}
		
		return this.add(inputWithoutDelimiterInfo, delimiter);
	}
	
    public int add(String input, String delimiter)
    {
    	if(input.isEmpty())
    	{
    		// returning 0 if string is empty
    		return 0;
    	}
    	else if(input.contains(",") || input.contains(delimiter.substring(0, 1)))
    	{
    		String[] tokens = input.split(delimiter);
    		
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