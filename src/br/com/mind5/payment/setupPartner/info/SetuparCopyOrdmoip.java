package br.com.mind5.payment.setupPartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

final class SetuparCopyOrdmoip extends InfoCopierTemplate<SetuparInfo, OrdmoipInfo>{
	
	public SetuparCopyOrdmoip() {
		super();
	}
	
	
	
	@Override protected SetuparInfo makeCopyHook(OrdmoipInfo source) {
		SetuparInfo result = new SetuparInfo();
		
		result.codPayPartner = source.cusparData.codPayPartner;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
