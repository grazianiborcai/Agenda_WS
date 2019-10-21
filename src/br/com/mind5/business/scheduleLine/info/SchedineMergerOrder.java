package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerOneToManyTemplate;
import br.com.mind5.info.InfoMergerOneToManyVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedineMergerOrder extends InfoMergerOneToManyTemplate<SchedineInfo, OrderInfo> {

	@Override protected InfoMergerOneToManyVisitor<SchedineInfo, OrderInfo> getVisitorHook() {
		return new SchedineVisiMergeOrder();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}	
}
