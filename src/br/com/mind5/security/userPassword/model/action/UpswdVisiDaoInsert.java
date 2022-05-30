package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.dao.UpswdDaoInsert;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdVisiDaoInsert extends ActionVisitorTemplateStmt<UpswdInfo> {

	public UpswdVisiDaoInsert(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UpswdInfo> buildStmtExecHook(List<DaoStmtExecOption<UpswdInfo>> stmtOptions) {
		return new UpswdDaoInsert(stmtOptions);
	}
}
