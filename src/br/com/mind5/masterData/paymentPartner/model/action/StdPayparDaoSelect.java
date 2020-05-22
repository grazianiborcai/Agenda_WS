package br.com.mind5.masterData.paymentPartner.model.action;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPayparDaoSelect extends ActionStdTemplateV2<PayparInfo> {

	public StdPayparDaoSelect(DeciTreeOption<PayparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PayparInfo> buildVisitorHook(DeciTreeOption<PayparInfo> option) {
		return new VisiPayparDaoSelect(option);
	}
}
