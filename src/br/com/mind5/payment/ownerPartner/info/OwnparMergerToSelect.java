package br.com.mind5.payment.ownerPartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnparMergerToSelect extends InfoMergerTemplate<OwnparInfo, OwnparInfo> {

	@Override protected InfoMergerVisitor<OwnparInfo, OwnparInfo> getVisitorHook() {
		return new OwnparVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwnparInfo> getUniquifierHook() {
		return new OwnparUniquifier();
	}
}
