package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0()
    {
        StringCalculator stringCalculator = new StringCalculator();
        
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int()
    {
        StringCalculator stringCalculator = new StringCalculator();
        
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
    void string_with_two_numbers_separated_with_commas_should_return_their_sum()
    {
    	StringCalculator stringCalculator = new StringCalculator();
    	
    	assertEquals(5, stringCalculator.add("2,3"));
    }
    
    @Test
    void string_with_multiple_numbers_separated_with_commas_should_return_their_sum()
    {
    	StringCalculator stringCalculator = new StringCalculator();
    	
    	assertEquals(25, stringCalculator.add("2,3,4,6,10"));
    }
    
    @Test
    void string_having_new_line_character_should_be_accepted()
    {
    	StringCalculator stringCalculator = new StringCalculator();
    	
    	assertEquals(25, stringCalculator.add("2,3\n4,6\n10"));
    }
}
