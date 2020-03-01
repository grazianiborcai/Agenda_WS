package br.com.mind5.payment.systemPartnerSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

final class SysparchCopyRefumoip extends InfoCopierTemplate<SysparchInfo, RefumoipInfo>{
	
	public SysparchCopyRefumoip() {
		super();
	}
	
	
	
	@Override protected SysparchInfo makeCopyHook(RefumoipInfo source) {
		SysparchInfo result = new SysparchInfo();
		
		result.idPayPartnerSystem = source.itemReceiver;
		result.codPayPartner = source.codPayPartner;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
