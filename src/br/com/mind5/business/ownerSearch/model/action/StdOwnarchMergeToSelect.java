package br.com.mind5.business.ownerSearch.model.action;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnarchMergeToSelect extends ActionStdTemplate<OwnarchInfo> {

	public StdOwnarchMergeToSelect(DeciTreeOption<OwnarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OwnarchInfo> buildVisitorHook(DeciTreeOption<OwnarchInfo> option) {
		return new VisiOwnarchMergeToSelect(option);
	}
}
