package br.com.gda.payment.storePartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoparMergerToDelete extends InfoMergerTemplate<StoparInfo, StoparInfo> {

	@Override protected InfoMergerVisitor<StoparInfo, StoparInfo> getVisitorHook() {
		return new StoparVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
