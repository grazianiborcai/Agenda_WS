package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerOneToManyTemplate_;
import br.com.mind5.info.obsolete.InfoMergerOneToManyVisitor_;

final class SchedineMergerOrder extends InfoMergerOneToManyTemplate_<SchedineInfo, OrderInfo> {

	@Override protected InfoMergerOneToManyVisitor_<SchedineInfo, OrderInfo> getVisitorHook() {
		return new SchedineVisiMergeOrder();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}	
}
