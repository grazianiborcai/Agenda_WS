package br.com.mind5.business.phoneSearch.model.action;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonarchMergeToSelect extends ActionStdTemplate<PhonarchInfo> {

	public StdPhonarchMergeToSelect(DeciTreeOption<PhonarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PhonarchInfo> buildVisitorHook(DeciTreeOption<PhonarchInfo> option) {
		return new VisiPhonarchMergeToSelect(option);
	}
}
