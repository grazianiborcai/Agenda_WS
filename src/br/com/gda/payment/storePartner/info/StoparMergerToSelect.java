package br.com.gda.payment.storePartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StoparMergerToSelect extends InfoMergerTemplate<StoparInfo, StoparInfo> {

	@Override protected InfoMergerVisitorV2<StoparInfo, StoparInfo> getVisitorHook() {
		return new StoparVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
