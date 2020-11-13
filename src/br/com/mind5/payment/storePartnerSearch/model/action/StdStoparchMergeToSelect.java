package br.com.mind5.payment.storePartnerSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StdStoparchMergeToSelect extends ActionStdTemplate<StoparchInfo> {

	public StdStoparchMergeToSelect(DeciTreeOption<StoparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoparchInfo> buildVisitorHook(DeciTreeOption<StoparchInfo> option) {
		return new VisiStoparchMergeToSelect(option);
	}
}
