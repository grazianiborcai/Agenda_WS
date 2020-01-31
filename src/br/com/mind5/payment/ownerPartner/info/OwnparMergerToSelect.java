package br.com.mind5.payment.ownerPartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnparMergerToSelect extends InfoMergerTemplate_<OwnparInfo, OwnparInfo> {

	@Override protected InfoMergerVisitor_<OwnparInfo, OwnparInfo> getVisitorHook() {
		return new OwnparVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwnparInfo> getUniquifierHook() {
		return new OwnparUniquifier();
	}
}
