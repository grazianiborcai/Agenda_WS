package br.com.mind5.payment.marketplacePartnerSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

final class MktpararchCopyRefumoip extends InfoCopierTemplate<MktpararchInfo, RefumoipInfo> {
	
	public MktpararchCopyRefumoip() {
		super();
	}
	
	
	
	@Override protected MktpararchInfo makeCopyHook(RefumoipInfo source) {
		MktpararchInfo result = new MktpararchInfo();
		
		result.idPayPartnerSystem = source.itemReceiver;
		result.codPayPartner = source.codPayPartner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
