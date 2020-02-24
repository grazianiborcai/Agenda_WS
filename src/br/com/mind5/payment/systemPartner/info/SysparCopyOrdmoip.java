package br.com.mind5.payment.systemPartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

final class SysparCopyOrdmoip extends InfoCopierTemplate<SysparInfo, OrdmoipInfo>{
	
	public SysparCopyOrdmoip() {
		super();
	}
	
	
	
	@Override protected SysparInfo makeCopyHook(OrdmoipInfo source) {
		SysparInfo result = new SysparInfo();
		
		result.codPayPartner = source.cusparData.codPayPartner;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
