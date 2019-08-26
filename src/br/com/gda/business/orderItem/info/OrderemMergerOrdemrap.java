package br.com.gda.business.orderItem.info;

import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerOrdemrap extends InfoMergerTemplate<OrderemInfo, OrdemrapInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, OrdemrapInfo> getVisitorHook() {
		return new OrderemVisiMergeOrdemrap();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
