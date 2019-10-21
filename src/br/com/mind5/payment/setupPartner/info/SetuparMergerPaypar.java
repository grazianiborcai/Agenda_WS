package br.com.mind5.payment.setupPartner.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SetuparMergerPaypar extends InfoMergerTemplate<SetuparInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<SetuparInfo,  PayparInfo> getVisitorHook() {
		return new SetuparVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<SetuparInfo> getUniquifierHook() {
		return new SetuparUniquifier();
	}
}
