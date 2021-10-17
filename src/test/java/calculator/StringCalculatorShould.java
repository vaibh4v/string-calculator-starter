package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorShould
{
	StringCalculator stringCalculator;
	
	// setup method to remove redundant code of instantiating StringCalculator for each test
	@BeforeEach
	void setup()
	{
		stringCalculator = new StringCalculator();
	}

    @Test
    void empty_string_should_return_0()
    {        
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int()
    {        
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
    void string_with_two_numbers_separated_with_commas_should_return_their_sum()
    {    	
    	assertEquals(5, stringCalculator.add("2,3"));
    }
    
    @Test
    void string_with_multiple_numbers_separated_with_commas_should_return_their_sum()
    {    	
    	assertEquals(25, stringCalculator.add("2,3,4,6,10"));
    }
    
    @Test
    void string_having_new_line_character_should_be_accepted()
    {    	
    	assertEquals(25, stringCalculator.add("2,3\n4,6\n10"));
    }
    
    @Test
    void string_having_different_delimiter_should_be_accepted()
    {    	
    	assertEquals(2, stringCalculator.add("//;\n1;1"));
    }
    
    @Test
    void string_having_different_delimiter_mixed_with_newline_should_be_accepted()
    {    	
    	assertEquals(5, stringCalculator.add("//;\n1;1\n1;1\n1"));
    }
    
    @Test
    void string_with_negative_numbers_should_throw_exception()
    {    	
    	assertThrows(RuntimeException.class, () -> {stringCalculator.add("2,-3,7,-4");});
    }
    
    @Test
    void string_with_negative_numbers_should_throw_exception_with_proper_message()
    {    	
    	try
    	{
    		stringCalculator.add("2,-3,7,-4");
    	}
    	catch(RuntimeException e)
    	{
    		assertEquals("negatives not allowed [-3, -4]", e.getMessage());
    	}
    }
    
    @Test
    void numbers_greater_than_1000_should_be_ignored()
    {
    	assertEquals(7, stringCalculator.add("4,1003,3"));
    }
}
