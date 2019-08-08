package br.com.gda.payment.setupPartner.info;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SetuparMergerPaypar extends InfoMergerTemplate<SetuparInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<SetuparInfo,  PayparInfo> getVisitorHook() {
		return new SetuparVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<SetuparInfo> getUniquifierHook() {
		return new SetuparUniquifier();
	}
}
