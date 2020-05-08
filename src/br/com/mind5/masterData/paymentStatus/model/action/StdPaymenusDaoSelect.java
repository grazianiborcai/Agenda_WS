package br.com.mind5.masterData.paymentStatus.model.action;

import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPaymenusDaoSelect extends ActionStdTemplateV2<PaymenusInfo> {

	public StdPaymenusDaoSelect(DeciTreeOption<PaymenusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PaymenusInfo> buildVisitorHook(DeciTreeOption<PaymenusInfo> option) {
		return new VisiPaymenusDaoSelect(option);
	}
}
