package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerarchMergeToSelect extends ActionStdTemplate<PerarchInfo> {

	public StdPerarchMergeToSelect(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PerarchInfo> buildVisitorHook(DeciTreeOption<PerarchInfo> option) {
		return new VisiPerarchMergeToSelect(option);
	}
}
