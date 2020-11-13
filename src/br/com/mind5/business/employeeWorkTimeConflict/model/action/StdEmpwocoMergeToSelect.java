package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwocoMergeToSelect extends ActionStdTemplate<EmpwocoInfo> {

	public StdEmpwocoMergeToSelect(DeciTreeOption<EmpwocoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmpwocoInfo> buildVisitorHook(DeciTreeOption<EmpwocoInfo> option) {
		return new VisiEmpwocoMergeToSelect(option);
	}
}
