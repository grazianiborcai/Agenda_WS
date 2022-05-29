package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.dao.UserDaoSelect;
import br.com.mind5.security.user.info.UserInfo;

public final class UserVisiDaoSelect extends ActionVisitorTemplateStmt<UserInfo> {

	public UserVisiDaoSelect(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UserInfo> buildStmtExecHook(List<DaoStmtExecOption<UserInfo>> stmtOptions) {
		return new UserDaoSelect(stmtOptions);
	}
}
