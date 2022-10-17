package com.crm.generic_utilitie;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	int count =0;
	int retrylimt=3;
	public boolean retry(ITestResult result) {
		if(count<retrylimt) {
			count++;
			return true;
		}
		return false;
	}
}
