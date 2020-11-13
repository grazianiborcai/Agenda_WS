package br.com.mind5.business.employee.model.action;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpMergeToDelete extends ActionStdTemplate<EmpInfo> {

	public StdEmpMergeToDelete(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmpInfo> buildVisitorHook(DeciTreeOption<EmpInfo> option) {
		return new VisiEmpMergeToDelete(option);
	}
}
