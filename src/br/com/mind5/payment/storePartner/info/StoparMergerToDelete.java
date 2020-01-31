package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoparMergerToDelete extends InfoMergerTemplate_<StoparInfo, StoparInfo> {

	@Override protected InfoMergerVisitor_<StoparInfo, StoparInfo> getVisitorHook() {
		return new StoparVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
