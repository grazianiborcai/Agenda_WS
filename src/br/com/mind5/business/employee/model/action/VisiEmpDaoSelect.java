package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.dao.DaoEmpSelect;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpDaoSelect extends ActionVisitorTemplateStmt<EmpInfo> {

	public VisiEmpDaoSelect(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpInfo>> stmtOptions) {
		return new DaoEmpSelect(stmtOptions);
	}
}
