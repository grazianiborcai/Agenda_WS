package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordSetterFee extends InfoSetterTemplate<PayordInfo> {
	
	@Override protected PayordInfo setAttrHook(PayordInfo recordInfo) {		
		recordInfo.payordems = new ArrayList<>();		
		PayordemInfo feeItem = new PayordemInfo();
		
		feeItem.codOwner = recordInfo.orderData.codOwner;
		feeItem.codPayOrder = recordInfo.codPayOrder; 
		feeItem.codPayOrderItem = 1;
		feeItem.codOrder = recordInfo.codOrder; 
		feeItem.codFeeCateg = recordInfo.orderData.codFeeCateg;
		feeItem.codPayPartner = recordInfo.codPayPartner;
		feeItem.quantity = 1;		
		feeItem.price = recordInfo.orderData.feeService;
		feeItem.totitem = recordInfo.orderData.feeService;
		feeItem.codCurr = recordInfo.orderData.codCurr;
		feeItem.codLanguage = recordInfo.codLanguage;
		feeItem.username = recordInfo.username;		
		
		recordInfo.payordems.add(feeItem);		
		return recordInfo;
	}
}
