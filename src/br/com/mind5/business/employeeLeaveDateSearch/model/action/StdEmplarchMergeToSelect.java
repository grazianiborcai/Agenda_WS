package br.com.mind5.business.employeeLeaveDateSearch.model.action;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplarchMergeToSelect extends ActionStdTemplate<EmplarchInfo> {

	public StdEmplarchMergeToSelect(DeciTreeOption<EmplarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmplarchInfo> buildVisitorHook(DeciTreeOption<EmplarchInfo> option) {
		return new VisiEmplarchMergeToSelect(option);
	}
}
