package br.com.gda.payment.setupPartner.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class SetuparCopyOrdmoip extends InfoCopierTemplate<SetuparInfo, OrdmoipInfo>{
	
	public SetuparCopyOrdmoip() {
		super();
	}
	
	
	
	@Override protected SetuparInfo makeCopyHook(OrdmoipInfo source) {
		SetuparInfo result = SetuparInfo.copyFrom(source);
		result.codPayPartner = source.cusparData.codPayPartner;
		
		return result;
	}
}
