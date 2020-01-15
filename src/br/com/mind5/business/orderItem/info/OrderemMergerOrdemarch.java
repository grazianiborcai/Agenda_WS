package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderemMergerOrdemarch extends InfoMergerTemplate<OrderemInfo, OrdemarchInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, OrdemarchInfo> getVisitorHook() {
		return new OrderemVisiMergeOrdemarch();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
