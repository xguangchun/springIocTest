package Test;

import com.mayi.bean.orderTest;
import com.mayi.util.MYXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	MYXmlApplicationContext context = new MYXmlApplicationContext("applicationContext.xml");
    	
    	orderTest order = (orderTest) context.getBean("xiaoguangchun");
    	System.out.println(order);
    }
}
