package br.com.mind5.payment.payOrderList.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class StdPayordistMergeToSelect extends ActionStdTemplate<PayordistInfo> {

	public StdPayordistMergeToSelect(DeciTreeOption<PayordistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PayordistInfo> buildVisitorHook(DeciTreeOption<PayordistInfo> option) {
		return new VisiPayordistMergeToSelect(option);
	}
}
