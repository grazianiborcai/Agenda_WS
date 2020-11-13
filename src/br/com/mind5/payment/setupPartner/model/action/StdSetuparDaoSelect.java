package br.com.mind5.payment.setupPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class StdSetuparDaoSelect extends ActionStdTemplate<SetuparInfo> {

	public StdSetuparDaoSelect(DeciTreeOption<SetuparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SetuparInfo> buildVisitorHook(DeciTreeOption<SetuparInfo> option) {
		return new VisiSetuparDaoSelect(option);
	}
}
