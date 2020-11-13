package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.dao.DaoEmplateDelete;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplateDaoDelete extends ActionVisitorTemplateStmt<EmplateInfo> {

	public VisiEmplateDaoDelete(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmplateInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplateInfo>> stmtOptions) {
		return new DaoEmplateDelete(stmtOptions);
	}
}
