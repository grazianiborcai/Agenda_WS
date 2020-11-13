package br.com.mind5.business.storeLeaveDateSearch.model.action;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolarchMergeToSelect extends ActionStdTemplate<StolarchInfo> {

	public StdStolarchMergeToSelect(DeciTreeOption<StolarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StolarchInfo> buildVisitorHook(DeciTreeOption<StolarchInfo> option) {
		return new VisiStolarchMergeToSelect(option);
	}
}
