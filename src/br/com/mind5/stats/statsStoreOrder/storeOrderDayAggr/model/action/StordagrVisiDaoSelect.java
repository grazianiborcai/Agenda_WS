package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.dao.StordagrDaoSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

public final class StordagrVisiDaoSelect extends ActionVisitorTemplateStmt<StordagrInfo> {

	public StordagrVisiDaoSelect(DeciTreeOption<StordagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StordagrInfo> buildStmtExecHook(List<DaoStmtExecOption<StordagrInfo>> stmtOptions) {
		return new StordagrDaoSelect(stmtOptions);
	}
}
