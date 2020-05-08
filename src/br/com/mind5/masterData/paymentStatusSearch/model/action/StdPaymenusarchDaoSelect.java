package br.com.mind5.masterData.paymentStatusSearch.model.action;

import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPaymenusarchDaoSelect extends ActionStdTemplateV2<PaymenusarchInfo> {

	public StdPaymenusarchDaoSelect(DeciTreeOption<PaymenusarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PaymenusarchInfo> buildVisitorHook(DeciTreeOption<PaymenusarchInfo> option) {
		return new VisiPaymenusarchDaoSelect(option);
	}
}
