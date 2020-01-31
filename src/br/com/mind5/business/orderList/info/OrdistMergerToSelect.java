package br.com.mind5.business.orderList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdistMergerToSelect extends InfoMergerTemplate_<OrdistInfo, OrdistInfo> {

	@Override protected InfoMergerVisitor_<OrdistInfo, OrdistInfo> getVisitorHook() {
		return new OrdistVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
