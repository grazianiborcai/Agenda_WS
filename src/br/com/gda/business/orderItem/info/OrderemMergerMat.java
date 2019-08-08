package br.com.gda.business.orderItem.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerMat extends InfoMergerTemplate<OrderemInfo, MatInfo> {

	@Override protected InfoMergerVisitor<OrderemInfo, MatInfo> getVisitorHook() {
		return new OrderemVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
