package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

final class CrecardMergerCremoip extends InfoMergerTemplate_<CrecardInfo, CremoipInfo> {

	@Override protected InfoMergerVisitor_<CrecardInfo, CremoipInfo> getVisitorHook() {
		return new CrecardVisiMergeCremoip();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
