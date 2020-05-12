package br.com.mind5.payment.customerPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class StdCusparDaoSelect extends ActionStdTemplateV2<CusparInfo> {

	public StdCusparDaoSelect(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CusparInfo> buildVisitorHook(DeciTreeOption<CusparInfo> option) {
		return new VisiCusparDaoSelect(option);
	}
}
