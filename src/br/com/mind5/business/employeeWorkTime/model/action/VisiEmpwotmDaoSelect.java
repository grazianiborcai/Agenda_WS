package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.dao.DaoEmpwotmSelect;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwotmDaoSelect extends ActionVisitorTemplateStmt<EmpwotmInfo> {

	public VisiEmpwotmDaoSelect(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpwotmInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpwotmInfo>> stmtOptions) {
		return new DaoEmpwotmSelect(stmtOptions);
	}
}
