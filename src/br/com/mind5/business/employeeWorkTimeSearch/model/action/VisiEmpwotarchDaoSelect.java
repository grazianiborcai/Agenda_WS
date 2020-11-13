package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.dao.DaoEmpwotarchSelect;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwotarchDaoSelect extends ActionVisitorTemplateStmt<EmpwotarchInfo> {

	public VisiEmpwotarchDaoSelect(DeciTreeOption<EmpwotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpwotarchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpwotarchInfo>> stmtOptions) {
		return new DaoEmpwotarchSelect(stmtOptions);
	}
}
