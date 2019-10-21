package br.com.mind5.business.orderList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdistMergerToSelect extends InfoMergerTemplate<OrdistInfo, OrdistInfo> {

	@Override protected InfoMergerVisitor<OrdistInfo, OrdistInfo> getVisitorHook() {
		return new OrdistVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
