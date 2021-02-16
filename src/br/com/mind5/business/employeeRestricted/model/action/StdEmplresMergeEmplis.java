package br.com.mind5.business.employeeRestricted.model.action;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplresMergeEmplis extends ActionStdTemplate<EmplresInfo> {

	public StdEmplresMergeEmplis(DeciTreeOption<EmplresInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmplresInfo> buildVisitorHook(DeciTreeOption<EmplresInfo> option) {
		return new VisiEmplresMergeEmplis(option);
	}
}
