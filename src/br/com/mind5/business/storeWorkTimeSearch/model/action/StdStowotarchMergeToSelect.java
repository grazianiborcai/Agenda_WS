package br.com.mind5.business.storeWorkTimeSearch.model.action;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotarchMergeToSelect extends ActionStdTemplate<StowotarchInfo> {

	public StdStowotarchMergeToSelect(DeciTreeOption<StowotarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StowotarchInfo> buildVisitorHook(DeciTreeOption<StowotarchInfo> option) {
		return new VisiStowotarchMergeToSelect(option);
	}
}
