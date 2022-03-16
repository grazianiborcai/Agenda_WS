package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.dao.StoreDaoDelete;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiDaoDelete extends ActionVisitorTemplateStmt<StoreInfo> {

	public StoreVisiDaoDelete(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoreInfo> buildStmtExecHook(List<DaoStmtExecOption<StoreInfo>> stmtOptions) {
		return new StoreDaoDelete(stmtOptions);
	}
}
