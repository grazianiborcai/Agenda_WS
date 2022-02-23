package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.dao.DaoStordagrInsert;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

final class VisiStordagrDaoInsert extends ActionVisitorTemplateStmt<StordagrInfo> {

	public VisiStordagrDaoInsert(DeciTreeOption<StordagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StordagrInfo> buildStmtExecHook(List<DaoStmtExecOption<StordagrInfo>> stmtOptions) {
		return new DaoStordagrInsert(stmtOptions);
	}
}
