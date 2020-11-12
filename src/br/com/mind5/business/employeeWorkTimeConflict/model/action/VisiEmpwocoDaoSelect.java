package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.dao.DaoEmpwocoSelect;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwocoDaoSelect extends ActionVisitorTemplateStmtV2<EmpwocoInfo> {

	public VisiEmpwocoDaoSelect(DeciTreeOption<EmpwocoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmpwocoInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpwocoInfo>> stmtOptions) {
		return new DaoEmpwocoSelect(stmtOptions);
	}
}
