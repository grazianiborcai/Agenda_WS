package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.dao.DaoUserInsert;
import br.com.mind5.security.user.info.UserInfo;

final class VisiUserDaoInsert extends ActionVisitorTemplateStmtV2<UserInfo> {

	public VisiUserDaoInsert(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<UserInfo> buildStmtExecHook(List<DaoStmtExecOption<UserInfo>> stmtOptions) {
		return new DaoUserInsert(stmtOptions);
	}
}
