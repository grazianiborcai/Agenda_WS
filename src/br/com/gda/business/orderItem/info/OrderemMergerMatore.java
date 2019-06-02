package br.com.gda.business.orderItem.info;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerMatore extends InfoMergerTemplate<OrderemInfo, MatoreInfo> {

	@Override protected InfoMergerVisitorV2<OrderemInfo, MatoreInfo> getVisitorHook() {
		return new OrderemVisiMergeMatore();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
