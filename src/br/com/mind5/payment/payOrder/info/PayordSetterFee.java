package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordSetterFee implements InfoSetter<PayordInfo> {
	
	public PayordInfo setAttr(PayordInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.payordems = new ArrayList<>();		
		PayordemInfo feeItem = new PayordemInfo();
		
		feeItem.codOwner = recordInfo.orderData.codOwner;
		feeItem.codPayOrder = recordInfo.codPayOrder; 
		feeItem.codPayOrderItem = 1;
		feeItem.codFeeCateg = recordInfo.orderData.codFeeCateg;
		feeItem.quantity = 1;		
		feeItem.price = recordInfo.orderData.feeService;
		feeItem.totitem = recordInfo.orderData.feeService;
		feeItem.codCurr = recordInfo.orderData.codCurr;
		feeItem.codLanguage = recordInfo.codLanguage;
		feeItem.username = recordInfo.username;		
		
		recordInfo.payordems.add(feeItem);		
		return recordInfo;
	}
	
	
	
	private void checkArgument(PayordInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
