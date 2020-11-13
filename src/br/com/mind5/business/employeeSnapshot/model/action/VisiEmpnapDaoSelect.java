package br.com.mind5.business.employeeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeSnapshot.dao.DaoEmpnapSelect;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpnapDaoSelect extends ActionVisitorTemplateStmt<EmpnapInfo> {

	public VisiEmpnapDaoSelect(DeciTreeOption<EmpnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpnapInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpnapInfo>> stmtOptions) {
		return new DaoEmpnapSelect(stmtOptions);
	}
}
