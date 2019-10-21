package br.com.mind5.payment.setupPartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

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
