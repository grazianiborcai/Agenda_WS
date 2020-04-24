package br.com.mind5.payment.storePartnerList.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StdStoplisMergeToSelect extends ActionStdTemplateV2<StoplisInfo> {

	public StdStoplisMergeToSelect(DeciTreeOption<StoplisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoplisInfo> buildVisitorHook(DeciTreeOption<StoplisInfo> option) {
		return new VisiStoplisMergeToSelect(option);
	}
}
