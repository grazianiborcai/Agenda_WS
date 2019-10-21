package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderemMergerMat extends InfoMergerTemplate<OrderemInfo, MatInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, MatInfo> getVisitorHook() {
		return new OrderemVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
