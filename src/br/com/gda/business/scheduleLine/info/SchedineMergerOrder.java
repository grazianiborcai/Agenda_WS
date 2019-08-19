package br.com.gda.business.scheduleLine.info;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoMergerOneToManyTemplate;
import br.com.gda.info.InfoMergerOneToManyVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedineMergerOrder extends InfoMergerOneToManyTemplate<SchedineInfo, OrderInfo> {

	@Override protected InfoMergerOneToManyVisitor<SchedineInfo, OrderInfo> getVisitorHook() {
		return new SchedineVisiMergeOrder();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}	
}
