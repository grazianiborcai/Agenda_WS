package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.dao.StoronagrDaoDelete;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

public final class StoronagrVisiDaoDelete extends ActionVisitorTemplateStmt<StoronagrInfo> {

	public StoronagrVisiDaoDelete(DeciTreeOption<StoronagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoronagrInfo> buildStmtExecHook(List<DaoStmtExecOption<StoronagrInfo>> stmtOptions) {
		return new StoronagrDaoDelete(stmtOptions);
	}
}
