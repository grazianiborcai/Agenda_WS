package br.com.mind5.payment.setupPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class StdSetuparDaoSelect extends ActionStdTemplateV2<SetuparInfo> {

	public StdSetuparDaoSelect(DeciTreeOption<SetuparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SetuparInfo> buildVisitorHook(DeciTreeOption<SetuparInfo> option) {
		return new VisiSetuparDaoSelect(option);
	}
}
