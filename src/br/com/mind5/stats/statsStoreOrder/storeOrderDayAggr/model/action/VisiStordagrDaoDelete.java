package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.dao.DaoStordagrDelete;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

final class VisiStordagrDaoDelete extends ActionVisitorTemplateStmt<StordagrInfo> {

	public VisiStordagrDaoDelete(DeciTreeOption<StordagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StordagrInfo> buildStmtExecHook(List<DaoStmtExecOption<StordagrInfo>> stmtOptions) {
		return new DaoStordagrDelete(stmtOptions);
	}
}
