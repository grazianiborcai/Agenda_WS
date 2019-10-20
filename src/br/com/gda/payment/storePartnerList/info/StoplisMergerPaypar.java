package br.com.gda.payment.storePartnerList.info;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoplisMergerPaypar extends InfoMergerTemplate<StoplisInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<StoplisInfo, PayparInfo> getVisitorHook() {
		return new StoplisVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<StoplisInfo> getUniquifierHook() {
		return new StoplisUniquifier();
	}
}
