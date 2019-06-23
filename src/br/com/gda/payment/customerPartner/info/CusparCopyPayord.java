package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class CusparCopyPayord extends InfoCopierTemplate<CusparInfo, PayordInfo>{
	
	public CusparCopyPayord() {
		super();
	}
	
	
	
	@Override protected CusparInfo makeCopyHook(PayordInfo source) {
		CusparInfo result = CusparInfo.copyFrom(source);
		result.codAddress = source.codAddressPay;
		result.codAddressSnapshot = source.codAddressPaySnapshot;
		result.codPhone = source.codPhonePay;
		result.codPhoneSnapshot = source.codPhonePaySnapshot;		
		
		return result;
	}
}
