package br.com.gda.business.orderItem.info;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerMatsnap extends InfoMergerTemplate<OrderemInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitorV2<OrderemInfo, MatsnapInfo> getVisitorHook() {
		return new OrderemVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<OrderemInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
