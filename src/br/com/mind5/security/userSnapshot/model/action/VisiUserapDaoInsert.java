package br.com.mind5.security.userSnapshot.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.dao.DaoUserapInsert;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class VisiUserapDaoInsert extends ActionVisitorTemplateStmt<UserapInfo> {

	public VisiUserapDaoInsert(DeciTreeOption<UserapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UserapInfo> buildStmtExecHook(List<DaoStmtExecOption<UserapInfo>> stmtOptions) {
		return new DaoUserapInsert(stmtOptions);
	}
}
