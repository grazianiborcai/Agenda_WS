package br.com.gda.payment.partnerMoip.creditCardMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class CremoipMergerSetupar extends InfoMergerTemplate<CremoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<CremoipInfo, SetuparInfo> getVisitorHook() {
		return new CremoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<CremoipInfo> getUniquifierHook() {
		return new CremoipUniquifier();
	}
}
