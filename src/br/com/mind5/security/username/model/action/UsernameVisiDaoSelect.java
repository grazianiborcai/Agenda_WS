package br.com.mind5.security.username.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.dao.UsernameDaoSelect;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UsernameVisiDaoSelect extends ActionVisitorTemplateStmt<UsernameInfo> {

	public UsernameVisiDaoSelect(DeciTreeOption<UsernameInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UsernameInfo> buildStmtExecHook(List<DaoStmtExecOption<UsernameInfo>> stmtOptions) {
		return new UsernameDaoSelect(stmtOptions);
	}
}
