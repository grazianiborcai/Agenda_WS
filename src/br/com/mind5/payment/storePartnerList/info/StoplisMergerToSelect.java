package br.com.mind5.payment.storePartnerList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoplisMergerToSelect extends InfoMergerTemplate_<StoplisInfo, StoplisInfo> {

	@Override protected InfoMergerVisitor_<StoplisInfo, StoplisInfo> getVisitorHook() {
		return new StoplisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoplisInfo> getUniquifierHook() {
		return new StoplisUniquifier();
	}
}
