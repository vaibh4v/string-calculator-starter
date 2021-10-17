package calculator;

import java.util.ArrayList;
import java.util.List;

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
    	List<Integer> negativeNumbers = new ArrayList<>();
    	
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
    			// keeping a track of negative numbers
    			if(Integer.parseInt(num) < 0)
    			{
    				negativeNumbers.add(Integer.parseInt(num));
    			}
    			
    			sum += Integer.parseInt(num);
    		}
    		
    		// throwing a run time exception in case of negative numbers
    		if(negativeNumbers.size() > 0)
    		{
    			throw new RuntimeException("negatives not allowed " + negativeNumbers.toString());
    		}
    		
    		return sum;
    	}
    	else
    	{
    		return Integer.parseInt(input);
    	}
    }
}