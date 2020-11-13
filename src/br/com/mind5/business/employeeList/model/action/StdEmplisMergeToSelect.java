package br.com.mind5.business.employeeList.model.action;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplisMergeToSelect extends ActionStdTemplate<EmplisInfo> {

	public StdEmplisMergeToSelect(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmplisInfo> buildVisitorHook(DeciTreeOption<EmplisInfo> option) {
		return new VisiEmplisMergeToSelect(option);
	}
}
