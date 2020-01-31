package br.com.mind5.payment.storePartner.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoparMergerPaypar extends InfoMergerTemplate_<StoparInfo, PayparInfo> {

	@Override protected InfoMergerVisitor_<StoparInfo, PayparInfo> getVisitorHook() {
		return new StoparVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
