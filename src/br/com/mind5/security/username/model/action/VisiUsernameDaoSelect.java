package br.com.mind5.security.username.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.dao.DaoUsernameSelect;
import br.com.mind5.security.username.info.UsernameInfo;

final class VisiUsernameDaoSelect extends ActionVisitorTemplateStmt<UsernameInfo> {

	public VisiUsernameDaoSelect(DeciTreeOption<UsernameInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UsernameInfo> buildStmtExecHook(List<DaoStmtExecOption<UsernameInfo>> stmtOptions) {
		return new DaoUsernameSelect(stmtOptions);
	}
}
