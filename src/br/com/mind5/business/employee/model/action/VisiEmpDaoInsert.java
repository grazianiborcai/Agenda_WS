package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.dao.DaoEmpInsert;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpDaoInsert extends ActionVisitorTemplateStmt<EmpInfo> {

	public VisiEmpDaoInsert(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpInfo>> stmtOptions) {
		return new DaoEmpInsert(stmtOptions);
	}
}
