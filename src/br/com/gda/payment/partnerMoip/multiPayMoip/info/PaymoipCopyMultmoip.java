package br.com.gda.payment.partnerMoip.multiPayMoip.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PaymoipCopyMultmoip extends InfoCopierTemplate<PaymoipInfo, MultmoipInfo>{
	
	public PaymoipCopyMultmoip() {
		super();
	}
	
	
	
	@Override protected PaymoipInfo makeCopyHook(MultmoipInfo source) {
		PaymoipInfo result = new PaymoipInfo();
		
		result.idOrderPartner = source.idOrderPartner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		result.cusparData = source.cusparData;
		result.crecardData = source.crecardData;
		result.sysparData = source.sysparData;
		result.setuparData = source.setuparData;		
		
		return result;
	}
}
