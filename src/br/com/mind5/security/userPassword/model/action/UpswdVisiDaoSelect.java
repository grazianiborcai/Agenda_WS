package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.dao.UpswdDaoSelect;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdVisiDaoSelect extends ActionVisitorTemplateStmt<UpswdInfo> {

	public UpswdVisiDaoSelect(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UpswdInfo> buildStmtExecHook(List<DaoStmtExecOption<UpswdInfo>> stmtOptions) {
		return new UpswdDaoSelect(stmtOptions);
	}
}
