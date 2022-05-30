package br.com.mind5.security.userSnapshot.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.dao.UserapDaoSelect;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class UserapVisiDaoSelect extends ActionVisitorTemplateStmt<UserapInfo> {

	public UserapVisiDaoSelect(DeciTreeOption<UserapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UserapInfo> buildStmtExecHook(List<DaoStmtExecOption<UserapInfo>> stmtOptions) {
		return new UserapDaoSelect(stmtOptions);
	}
}
