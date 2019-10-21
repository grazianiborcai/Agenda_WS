package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

final class CrecardMergerCremoip extends InfoMergerTemplate<CrecardInfo, CremoipInfo> {

	@Override protected InfoMergerVisitor<CrecardInfo, CremoipInfo> getVisitorHook() {
		return new CrecardVisiMergeCremoip();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
