package br.com.mind5.payment.setupPartner.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SetuparMergerPaypar extends InfoMergerTemplate_<SetuparInfo, PayparInfo> {

	@Override protected InfoMergerVisitor_<SetuparInfo,  PayparInfo> getVisitorHook() {
		return new SetuparVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<SetuparInfo> getUniquifierHook() {
		return new SetuparUniquifier();
	}
}
