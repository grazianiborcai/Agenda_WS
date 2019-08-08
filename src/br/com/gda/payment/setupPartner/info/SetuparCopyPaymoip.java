package br.com.gda.payment.setupPartner.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class SetuparCopyPaymoip extends InfoCopierTemplate<SetuparInfo, PaymoipInfo>{
	
	public SetuparCopyPaymoip() {
		super();
	}
	
	
	
	@Override protected SetuparInfo makeCopyHook(PaymoipInfo source) {
		SetuparInfo result = SetuparInfo.copyFrom(source);
		result.codPayPartner = source.cusparData.codPayPartner;
		
		return result;
	}
}
