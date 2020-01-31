package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemMergerOrdemrap extends InfoMergerTemplate_<OrderemInfo, OrdemrapInfo> {

	@Override protected InfoMergerVisitor_<OrderemInfo, OrdemrapInfo> getVisitorHook() {
		return new OrderemVisiMergeOrdemrap();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
