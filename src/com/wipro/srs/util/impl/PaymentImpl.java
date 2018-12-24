package com.wipro.srs.util.impl;

import com.wipro.srs.bean.PaymentBean;
import com.wipro.srs.dao.CustomerDAO;
import com.wipro.srs.dao.impl.CustomerDaoImpl;
import com.wipro.srs.util.Payment;

public class PaymentImpl implements Payment {

	@Override
	public boolean findByCardNumber(String urid, String creditCardNumber) {
		CustomerDAO customerdao= new CustomerDaoImpl();
		return customerdao.findByCardNumber(urid,creditCardNumber); 
	}

	@Override
	public String process(PaymentBean pb) {
		CustomerDAO customerdao=new CustomerDaoImpl();
		return customerdao.process(pb);
	}



}
