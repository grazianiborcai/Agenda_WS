package br.com.mind5.payment.payOrderSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class StdPayordarchDaoSelect extends ActionStdTemplateV2<PayordarchInfo> {

	public StdPayordarchDaoSelect(DeciTreeOption<PayordarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PayordarchInfo> buildVisitorHook(DeciTreeOption<PayordarchInfo> option) {
		return new VisiPayordarchDaoSelect(option);
	}
}
