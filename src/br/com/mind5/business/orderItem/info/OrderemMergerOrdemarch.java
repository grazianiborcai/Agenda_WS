package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemMergerOrdemarch extends InfoMergerTemplate_<OrderemInfo, OrdemarchInfo> {

	@Override protected InfoMergerVisitor_<OrderemInfo, OrdemarchInfo> getVisitorHook() {
		return new OrderemVisiMergeOrdemarch();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
