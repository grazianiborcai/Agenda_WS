package br.com.gda.payment.setupPartner.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;

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
