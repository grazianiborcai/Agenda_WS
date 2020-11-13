package br.com.mind5.business.phoneDefault.model.action;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonaultDaoSelect extends ActionStdTemplate<PhonaultInfo> {

	public StdPhonaultDaoSelect(DeciTreeOption<PhonaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PhonaultInfo> buildVisitorHook(DeciTreeOption<PhonaultInfo> option) {
		return new VisiPhonaultDaoSelect(option);
	}
}
