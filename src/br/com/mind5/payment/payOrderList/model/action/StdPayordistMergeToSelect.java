package br.com.mind5.payment.payOrderList.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class StdPayordistMergeToSelect extends ActionStdTemplateV2<PayordistInfo> {

	public StdPayordistMergeToSelect(DeciTreeOption<PayordistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PayordistInfo> buildVisitorHook(DeciTreeOption<PayordistInfo> option) {
		return new VisiPayordistMergeToSelect(option);
	}
}
