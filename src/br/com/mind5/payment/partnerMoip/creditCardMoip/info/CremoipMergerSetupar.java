package br.com.mind5.payment.partnerMoip.creditCardMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class CremoipMergerSetupar extends InfoMergerTemplate<CremoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<CremoipInfo, SetuparInfo> getVisitorHook() {
		return new CremoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<CremoipInfo> getUniquifierHook() {
		return new CremoipUniquifier();
	}
}
