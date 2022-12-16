package br.com.mind5.payment.marketplacePartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

final class MktparCopyOrdmoip extends InfoCopierTemplate<MktparInfo, OrdmoipInfo> {
	
	public MktparCopyOrdmoip() {
		super();
	}
	
	
	
	@Override protected MktparInfo makeCopyHook(OrdmoipInfo source) {
		MktparInfo result = new MktparInfo();
		
		result.codPayPartner = source.cusparData.codPayPartner;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
