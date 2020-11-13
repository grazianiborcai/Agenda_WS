package br.com.mind5.masterData.paymentStatus.model.action;

import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPaymenusDaoSelect extends ActionStdTemplate<PaymenusInfo> {

	public StdPaymenusDaoSelect(DeciTreeOption<PaymenusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PaymenusInfo> buildVisitorHook(DeciTreeOption<PaymenusInfo> option) {
		return new VisiPaymenusDaoSelect(option);
	}
}
