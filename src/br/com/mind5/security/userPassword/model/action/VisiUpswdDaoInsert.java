package br.com.mind5.security.userPassword.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.dao.DaoUpswdInsert;
import br.com.mind5.security.userPassword.info.UpswdInfo;

final class VisiUpswdDaoInsert extends ActionVisitorTemplateStmtV2<UpswdInfo>{

	public VisiUpswdDaoInsert(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<UpswdInfo> buildStmtExecHook(List<DaoStmtExecOption<UpswdInfo>> stmtOptions) {
		return new DaoUpswdInsert(stmtOptions);
	}
}
