package br.com.mind5.business.employeeLeaveDateRange.model.action;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplargMergeToSelect extends ActionStdTemplate<EmplargInfo> {

	public StdEmplargMergeToSelect(DeciTreeOption<EmplargInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmplargInfo> buildVisitorHook(DeciTreeOption<EmplargInfo> option) {
		return new VisiEmplargMergeToSelect(option);
	}
}
