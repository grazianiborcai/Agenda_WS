package br.com.mind5.business.employeeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTime.dao.EmplutmDaoDelete;
import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmVisiDaoDelete extends ActionVisitorTemplateStmt<EmplutmInfo> {

	public EmplutmVisiDaoDelete(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmplutmInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplutmInfo>> stmtOptions) {
		return new EmplutmDaoDelete(stmtOptions);
	}
}
