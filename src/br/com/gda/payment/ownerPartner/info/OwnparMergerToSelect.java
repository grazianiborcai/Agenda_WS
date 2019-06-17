package br.com.gda.payment.ownerPartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OwnparMergerToSelect extends InfoMergerTemplate<OwnparInfo, OwnparInfo> {

	@Override protected InfoMergerVisitorV2<OwnparInfo, OwnparInfo> getVisitorHook() {
		return new OwnparVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OwnparInfo> getUniquifierHook() {
		return new OwnparUniquifier();
	}
}
