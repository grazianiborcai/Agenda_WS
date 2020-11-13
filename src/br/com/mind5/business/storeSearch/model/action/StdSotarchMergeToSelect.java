package br.com.mind5.business.storeSearch.model.action;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSotarchMergeToSelect extends ActionStdTemplate<SotarchInfo> {

	public StdSotarchMergeToSelect(DeciTreeOption<SotarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SotarchInfo> buildVisitorHook(DeciTreeOption<SotarchInfo> option) {
		return new VisiSotarchMergeToSelect(option);
	}
}
