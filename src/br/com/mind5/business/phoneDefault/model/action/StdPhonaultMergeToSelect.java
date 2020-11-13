package br.com.mind5.business.phoneDefault.model.action;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonaultMergeToSelect extends ActionStdTemplate<PhonaultInfo> {

	public StdPhonaultMergeToSelect(DeciTreeOption<PhonaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PhonaultInfo> buildVisitorHook(DeciTreeOption<PhonaultInfo> option) {
		return new VisiPhonaultMergeToSelect(option);
	}
}
