package br.com.mind5.masterData.paymentStatusSearch.model.action;

import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPaymenusarchDaoSelect extends ActionStdTemplate<PaymenusarchInfo> {

	public StdPaymenusarchDaoSelect(DeciTreeOption<PaymenusarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PaymenusarchInfo> buildVisitorHook(DeciTreeOption<PaymenusarchInfo> option) {
		return new VisiPaymenusarchDaoSelect(option);
	}
}
