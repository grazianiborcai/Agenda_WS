package br.com.mind5.payment.partnerMoip.creditCardMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class CremoipMergerSetupar extends InfoMergerTemplate_<CremoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor_<CremoipInfo, SetuparInfo> getVisitorHook() {
		return new CremoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<CremoipInfo> getUniquifierHook() {
		return new CremoipUniquifier();
	}
}
