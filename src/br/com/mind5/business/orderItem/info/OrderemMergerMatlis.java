package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemMergerMatlis extends InfoMergerTemplate_<OrderemInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<OrderemInfo, MatlisInfo> getVisitorHook() {
		return new OrderemVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
