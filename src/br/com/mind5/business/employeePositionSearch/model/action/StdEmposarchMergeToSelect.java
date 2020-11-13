package br.com.mind5.business.employeePositionSearch.model.action;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmposarchMergeToSelect extends ActionStdTemplate<EmposarchInfo> {

	public StdEmposarchMergeToSelect(DeciTreeOption<EmposarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmposarchInfo> buildVisitorHook(DeciTreeOption<EmposarchInfo> option) {
		return new VisiEmposarchMergeToSelect(option);
	}
}
