package br.com.mind5.security.userSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.dao.UserarchDaoSelect;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class UserarchVisiDaoSelect extends ActionVisitorTemplateStmt<UserarchInfo> {

	public UserarchVisiDaoSelect(DeciTreeOption<UserarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UserarchInfo> buildStmtExecHook(List<DaoStmtExecOption<UserarchInfo>> stmtOptions) {
		return new UserarchDaoSelect(stmtOptions);
	}
}
