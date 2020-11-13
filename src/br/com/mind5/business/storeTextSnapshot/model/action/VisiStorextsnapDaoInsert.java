package br.com.mind5.business.storeTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeTextSnapshot.dao.DaoStorextsnapInsert;
import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextsnapDaoInsert extends ActionVisitorTemplateStmt<StorextsnapInfo> {

	public VisiStorextsnapDaoInsert(DeciTreeOption<StorextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StorextsnapInfo> buildStmtExecHook(List<DaoStmtExecOption<StorextsnapInfo>> stmtOptions) {
		return new DaoStorextsnapInsert(stmtOptions);
	}
}
