package br.com.mind5.payment.setupPartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

final class SetuparCopyCremoip extends InfoCopierTemplate<SetuparInfo, CremoipInfo>{
	
	public SetuparCopyCremoip() {
		super();
	}
	
	
	
	@Override protected SetuparInfo makeCopyHook(CremoipInfo source) {
		SetuparInfo result = SetuparInfo.copyFrom(source);
		result.codPayPartner = source.cusparData.codPayPartner;
		
		return result;
	}
}
