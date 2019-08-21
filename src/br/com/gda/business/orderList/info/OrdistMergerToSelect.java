package br.com.gda.business.orderList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdistMergerToSelect extends InfoMergerTemplate<OrdistInfo, OrdistInfo> {

	@Override protected InfoMergerVisitor<OrdistInfo, OrdistInfo> getVisitorHook() {
		return new OrdistVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
