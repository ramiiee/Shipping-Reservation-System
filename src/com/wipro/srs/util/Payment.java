package com.wipro.srs.util;

import com.wipro.srs.bean.PaymentBean;

public interface Payment {

	boolean findByCardNumber(String urid, String cardnumber); 
	String process(PaymentBean pb);
}
