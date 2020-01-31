package br.com.mind5.payment.storePartnerList.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoplisMergerPaypar extends InfoMergerTemplate_<StoplisInfo, PayparInfo> {

	@Override protected InfoMergerVisitor_<StoplisInfo, PayparInfo> getVisitorHook() {
		return new StoplisVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<StoplisInfo> getUniquifierHook() {
		return new StoplisUniquifier();
	}
}
