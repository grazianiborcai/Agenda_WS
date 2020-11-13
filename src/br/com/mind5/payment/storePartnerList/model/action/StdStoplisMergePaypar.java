package br.com.mind5.payment.storePartnerList.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StdStoplisMergePaypar extends ActionStdTemplate<StoplisInfo> {

	public StdStoplisMergePaypar(DeciTreeOption<StoplisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoplisInfo> buildVisitorHook(DeciTreeOption<StoplisInfo> option) {
		return new VisiStoplisMergePaypar(option);
	}
}
