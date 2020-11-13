package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.dao.DaoEmpwocoSelect;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwocoDaoSelect extends ActionVisitorTemplateStmt<EmpwocoInfo> {

	public VisiEmpwocoDaoSelect(DeciTreeOption<EmpwocoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpwocoInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpwocoInfo>> stmtOptions) {
		return new DaoEmpwocoSelect(stmtOptions);
	}
}
