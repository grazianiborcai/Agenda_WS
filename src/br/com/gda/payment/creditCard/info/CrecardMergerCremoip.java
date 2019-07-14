package br.com.gda.payment.creditCard.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

final class CrecardMergerCremoip extends InfoMergerTemplate<CrecardInfo, CremoipInfo> {

	@Override protected InfoMergerVisitorV2<CrecardInfo, CremoipInfo> getVisitorHook() {
		return new CrecardVisiMergeCremoip();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
