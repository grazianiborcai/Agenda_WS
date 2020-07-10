package br.com.mind5.payment.setupPartner.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class SetuparCopyPaymoip extends InfoCopierTemplate<SetuparInfo, PaymoipInfo> {
	
	public SetuparCopyPaymoip() {
		super();
	}
	
	
	
	@Override protected SetuparInfo makeCopyHook(PaymoipInfo source) {
		SetuparInfo result = SetuparInfo.copyFrom(source);
		result.codPayPartner = source.codPayPartner;
		
		return result;
	}
}
