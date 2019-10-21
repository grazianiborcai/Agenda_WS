package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderemMergerMatore extends InfoMergerTemplate<OrderemInfo, MatoreInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, MatoreInfo> getVisitorHook() {
		return new OrderemVisiMergeMatore();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
