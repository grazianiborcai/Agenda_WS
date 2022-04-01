package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.dao.EmplateDaoUpdate;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateVisiDaoUpdate extends ActionVisitorTemplateStmt<EmplateInfo> {

	public EmplateVisiDaoUpdate(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmplateInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplateInfo>> stmtOptions) {
		return new EmplateDaoUpdate(stmtOptions);
	}
}
