package br.com.mind5.business.orderList.info;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdistMergerOrdarch extends InfoMergerTemplate_<OrdistInfo, OrdarchInfo> {

	@Override protected InfoMergerVisitor_<OrdistInfo, OrdarchInfo> getVisitorHook() {
		return new OrdistVisiMergeOrdarch();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
