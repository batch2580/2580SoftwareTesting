package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown 
  {
	public static void handleSelectClass(WebElement ele, String value)
	{
		Select s = new Select(ele);        // ele = store all the webelement through x path (particilar element)
		s.selectByVisibleText(value);      // String value it saves all the values (its options)
	    
	}

 }
