package br.com.gda.business.orderItem.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerMat extends InfoMergerTemplate<OrderemInfo, MatInfo> {

	@Override protected InfoMergerVisitorV2<OrderemInfo, MatInfo> getVisitorHook() {
		return new OrderemVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
