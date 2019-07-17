package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class MultmoipCopyPayord extends InfoCopierTemplate<MultmoipInfo, PayordInfo>{
	
	public MultmoipCopyPayord() {
		super();
	}
	
	
	
	@Override protected MultmoipInfo makeCopyHook(PayordInfo source) {
		MultmoipInfo result = new MultmoipInfo();
		
		result.codOwner = source.codOwner;
		result.codPayOrder = source.codPayOrder;	
		result.feeReceiver = source.feeReceiver;		
		result.feeAmount = source.feeAmount;
		result.codFeeCurrency = source.codFeeCurrency;
		result.codPaymentStatus = source.codPaymentStatus;		
		result.codLanguage = source.codLanguage;
		result.username = source.username;		
		result.payordems = source.payordems;
		result.cusparData = source.cusparData;
		result.sysparData = source.sysparData;
		result.codFeeCateg = source.orderData.codFeeCateg;
		result.txtFeeCateg = source.orderData.txtFeeCateg;
		
		return result;
	}
}
