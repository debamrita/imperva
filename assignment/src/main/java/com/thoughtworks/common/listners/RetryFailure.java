/**
 * @author Debamrita
 *
 */
package com.thoughtworks.common.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Debamrita
 *
 */
public class RetryFailure implements IRetryAnalyzer {
	 private int count = 0;
	    private static int maxTry = 2;

	/* (non-Javadoc)
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 */
	public boolean retry(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		if (!iTestResult.isSuccess()) {                      
            if (count < maxTry) {                            
                count++;                                     
                iTestResult.setStatus(ITestResult.FAILURE);  
                return true;                                 
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);  
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      
        }
		return false;
	}

}
