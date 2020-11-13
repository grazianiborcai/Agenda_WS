package br.com.mind5.payment.payOrderSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class StdPayordarchMergeToSelect extends ActionStdTemplate<PayordarchInfo> {

	public StdPayordarchMergeToSelect(DeciTreeOption<PayordarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PayordarchInfo> buildVisitorHook(DeciTreeOption<PayordarchInfo> option) {
		return new VisiPayordarchMergeToSelect(option);
	}
}
