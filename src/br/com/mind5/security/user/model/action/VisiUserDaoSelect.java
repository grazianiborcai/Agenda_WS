package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.dao.DaoUserSelect;
import br.com.mind5.security.user.info.UserInfo;

final class VisiUserDaoSelect extends ActionVisitorTemplateStmt<UserInfo> {

	public VisiUserDaoSelect(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UserInfo> buildStmtExecHook(List<DaoStmtExecOption<UserInfo>> stmtOptions) {
		return new DaoUserSelect(stmtOptions);
	}
}
