package br.com.mind5.security.username.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.dao.DaoUsernameSelect;
import br.com.mind5.security.username.info.UsernameInfo;

final class VisiUsernameDaoSelect extends ActionVisitorTemplateStmtV2<UsernameInfo> {

	public VisiUsernameDaoSelect(DeciTreeOption<UsernameInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<UsernameInfo> buildStmtExecHook(List<DaoStmtExecOption<UsernameInfo>> stmtOptions) {
		return new DaoUsernameSelect(stmtOptions);
	}
}
