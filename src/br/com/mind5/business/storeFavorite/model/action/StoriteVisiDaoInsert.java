package br.com.mind5.business.storeFavorite.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavorite.dao.StoriteDaoInsert;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;

public final class StoriteVisiDaoInsert extends ActionVisitorTemplateStmt<StoriteInfo> {

	public StoriteVisiDaoInsert(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoriteInfo> buildStmtExecHook(List<DaoStmtExecOption<StoriteInfo>> stmtOptions) {
		return new StoriteDaoInsert(stmtOptions);
	}
}
