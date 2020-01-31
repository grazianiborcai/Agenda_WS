package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemMergerMatore extends InfoMergerTemplate_<OrderemInfo, MatoreInfo> {

	@Override protected InfoMergerVisitor_<OrderemInfo, MatoreInfo> getVisitorHook() {
		return new OrderemVisiMergeMatore();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
