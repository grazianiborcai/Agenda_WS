package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwocoDaoSelect extends ActionStdTemplateV2<EmpwocoInfo> {

	public StdEmpwocoDaoSelect(DeciTreeOption<EmpwocoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmpwocoInfo> buildVisitorHook(DeciTreeOption<EmpwocoInfo> option) {
		return new VisiEmpwocoDaoSelect(option);
	}
}
