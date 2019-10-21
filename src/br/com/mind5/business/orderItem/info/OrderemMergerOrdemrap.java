package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderemMergerOrdemrap extends InfoMergerTemplate<OrderemInfo, OrdemrapInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, OrdemrapInfo> getVisitorHook() {
		return new OrderemVisiMergeOrdemrap();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
