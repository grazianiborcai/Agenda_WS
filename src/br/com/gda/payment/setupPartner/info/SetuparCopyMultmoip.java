package br.com.gda.payment.setupPartner.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class SetuparCopyMultmoip extends InfoCopierTemplate<SetuparInfo, MultmoipInfo>{
	
	public SetuparCopyMultmoip() {
		super();
	}
	
	
	
	@Override protected SetuparInfo makeCopyHook(MultmoipInfo source) {
		SetuparInfo result = SetuparInfo.copyFrom(source);
		result.codPayPartner = source.cusparData.codPayPartner;
		
		return result;
	}
}
