package com.crm.generic_utilitie;

import java.util.Random;

public class Java_Utility {
public int getRandomNumber(int ranNum) {
	Random ran=new Random();
	int RanNum = ran.nextInt(ranNum);
	return RanNum;
}
}
