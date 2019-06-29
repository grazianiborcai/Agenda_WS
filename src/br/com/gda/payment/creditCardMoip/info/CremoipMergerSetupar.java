package br.com.gda.payment.creditCardMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class CremoipMergerSetupar extends InfoMergerTemplate<CremoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitorV2<CremoipInfo, SetuparInfo> getVisitorHook() {
		return new CremoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<CremoipInfo> getUniquifierHook() {
		return new CremoipUniquifier();
	}
}
