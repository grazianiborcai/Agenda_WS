package br.com.mind5.payment.setupPartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;

final class SetuparCopyRefumoip extends InfoCopierTemplate<SetuparInfo, RefumoipInfo>{
	
	public SetuparCopyRefumoip() {
		super();
	}
	
	
	
	@Override protected SetuparInfo makeCopyHook(RefumoipInfo source) {
		SetuparInfo result = SetuparInfo.copyFrom(source);
		result.codPayPartner = source.cusparData.codPayPartner;
		
		return result;
	}
}
