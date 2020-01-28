package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderemMergerMatlis extends InfoMergerTemplate<OrderemInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, MatlisInfo> getVisitorHook() {
		return new OrderemVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
