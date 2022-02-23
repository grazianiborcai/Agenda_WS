package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.dao.DaoStoronagrInsert;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

final class VisiStoronagrDaoInsert extends ActionVisitorTemplateStmt<StoronagrInfo> {

	public VisiStoronagrDaoInsert(DeciTreeOption<StoronagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoronagrInfo> buildStmtExecHook(List<DaoStmtExecOption<StoronagrInfo>> stmtOptions) {
		return new DaoStoronagrInsert(stmtOptions);
	}
}
