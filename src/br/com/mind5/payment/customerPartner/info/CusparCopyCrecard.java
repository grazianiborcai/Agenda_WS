package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

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
