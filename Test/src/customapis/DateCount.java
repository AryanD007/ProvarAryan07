package customapis;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="Date Compare"
        , summary=""
        , remarks=""
        , iconBase=""
        , defaultApiGroups={"Custom"}
        )
@TestApiParameterGroups(parameterGroups={
	    @TestApiParameterGroup(groupName="inputs", title="Inputs"),
	    @TestApiParameterGroup(groupName="result", title="Result"),
	    })
public class DateCount {
    
    @TestApiParameter(seq=1, 
            summary="The first parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String  param1;
    
    @TestApiParameter(seq=2, 
            summary="The second parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String param2;

    @TestApiParameter(seq=10, 
            summary="The name that the result will be stored under.",
            remarks="",
            mandatory=true,
            parameterGroup="result")
    public String resultName;

    @TestApiParameter(seq=11, 
            summary="The lifespan of the result.",
            remarks="",
            mandatory=true,
            parameterGroup="result",
            defaultValue="Test")
    public ValueScope resultScope;

    /** 
     * Used to write to the test execution log.
     */
    @TestLogger
    public static Logger testLogger;
    
    /** 
     * Provides access to facilities, mainly to set and get variable values.
     */
    @TestExecutionContext
    public ITestExecutionContext testExecutionContext;
    
    @TestApiExecutor
    public void execute() throws ParseException {
    	String dummyResult = "";
    	dummyResult= findDifference(param1, 
				param2); 
    	// Put our implementation logic here.
    	testLogger.info("Hello from " + this.getClass().getName());
    	
    	testLogger.info(">>>>>>>>>>...........");

        // Store the result (if appropriate).
    	
        testExecutionContext.setValue(resultName, dummyResult, resultScope);
        
    }
    
    
    static 	String findDifference(String start_date, 
			String end_date) 
{ 
    	
    	String a="";
// SimpleDateFormat converts the 
// string format to date object 
SimpleDateFormat sdf 
= new SimpleDateFormat( 
"dd-MM-yyyy HH:mm:ss"); 

// Try Class 
try { 

// parse method is used to parse 
// the text from a string to 
// produce the date 
Date d1 = sdf.parse(start_date); 
Date d2 = sdf.parse(end_date); 

// Calucalte time difference 
// in milliseconds 
long difference_In_Time =0;
if(d1.getTime()>d2.getTime())
{
difference_In_Time 
	= d1.getTime() - d2.getTime(); 
}
else {
	difference_In_Time 
	= d2.getTime() - d1.getTime();
} 

// Calucalte time difference in seconds, 
// minutes, hours, years, and days 
long difference_In_Seconds 
= TimeUnit.MILLISECONDS 
	.toSeconds(difference_In_Time) 
% 60; 

long difference_In_Minutes 
= TimeUnit 
	.MILLISECONDS 
	.toMinutes(difference_In_Time) 
% 60; 

long difference_In_Hours 
= TimeUnit 
	.MILLISECONDS 
	.toHours(difference_In_Time) 
% 24; 

long difference_In_Days 
= TimeUnit 
	.MILLISECONDS 
	.toDays(difference_In_Time) 
% 365; 

long difference_In_Years 
= TimeUnit 
	.MILLISECONDS 
	.toDays(difference_In_Time) 
/ 365l; 

// Print the date difference in 
// years, in days, in hours, in 
// minutes, and in seconds 
testLogger.info( "Difference" + " between two dates is: "); 

// Print result 
a = ""+difference_In_Years+" year "+difference_In_Days+" days "+difference_In_Hours+":"+difference_In_Minutes+":"+difference_In_Seconds;
return a;

} 
catch (ParseException e) { 
e.printStackTrace(); 
} 
return a;
} 
    
    
}
