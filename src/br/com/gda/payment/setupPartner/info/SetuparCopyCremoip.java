package br.com.gda.payment.setupPartner.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.creditCardMoip.info.CremoipInfo;

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
