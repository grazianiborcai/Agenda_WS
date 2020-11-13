package br.com.mind5.business.employeeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeSearch.dao.DaoEmparchSelect;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmparchDaoSelect extends ActionVisitorTemplateStmt<EmparchInfo> {

	public VisiEmparchDaoSelect(DeciTreeOption<EmparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmparchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmparchInfo>> stmtOptions) {
		return new DaoEmparchSelect(stmtOptions);
	}
}
