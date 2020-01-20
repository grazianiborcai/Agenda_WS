package br.com.mind5.business.orderList.info;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdistMergerOrdarch extends InfoMergerTemplate<OrdistInfo, OrdarchInfo> {

	@Override protected InfoMergerVisitor<OrdistInfo, OrdarchInfo> getVisitorHook() {
		return new OrdistVisiMergeOrdarch();
	}
	
	
	
	@Override protected InfoUniquifier<OrdistInfo> getUniquifierHook() {
		return new OrdistUniquifier();
	}
}
