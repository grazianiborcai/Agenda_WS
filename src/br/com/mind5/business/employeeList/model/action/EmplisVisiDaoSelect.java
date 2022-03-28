package br.com.mind5.business.employeeList.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.dao.EmplisDaoSelect;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplisVisiDaoSelect extends ActionVisitorTemplateStmt<EmplisInfo> {

	public EmplisVisiDaoSelect(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmplisInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplisInfo>> stmtOptions) {
		return new EmplisDaoSelect(stmtOptions);
	}
}
