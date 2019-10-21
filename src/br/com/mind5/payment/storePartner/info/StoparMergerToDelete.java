package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoparMergerToDelete extends InfoMergerTemplate<StoparInfo, StoparInfo> {

	@Override protected InfoMergerVisitor<StoparInfo, StoparInfo> getVisitorHook() {
		return new StoparVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
