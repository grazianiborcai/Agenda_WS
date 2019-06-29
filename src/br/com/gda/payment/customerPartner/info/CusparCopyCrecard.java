package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.creditCard.info.CrecardInfo;

final class CusparCopyCrecard extends InfoCopierTemplate<CusparInfo, CrecardInfo>{
	
	public CusparCopyCrecard() {
		super();
	}
	
	
	
	@Override protected CusparInfo makeCopyHook(CrecardInfo source) {
		CusparInfo result = CusparInfo.copyFrom(source);
		result.codAddress = source.codAddressHolder;
		result.codPhone = source.codPhoneHolder;	
		
		return result;
	}
}
