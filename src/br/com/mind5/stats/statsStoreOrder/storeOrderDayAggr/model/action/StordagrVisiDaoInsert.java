package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.dao.StordagrDaoInsert;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

public final class StordagrVisiDaoInsert extends ActionVisitorTemplateStmt<StordagrInfo> {

	public StordagrVisiDaoInsert(DeciTreeOption<StordagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StordagrInfo> buildStmtExecHook(List<DaoStmtExecOption<StordagrInfo>> stmtOptions) {
		return new StordagrDaoInsert(stmtOptions);
	}
}
