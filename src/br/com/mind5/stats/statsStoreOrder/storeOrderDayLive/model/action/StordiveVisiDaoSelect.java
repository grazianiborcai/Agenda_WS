package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.dao.StordiveDaoSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;

public final class StordiveVisiDaoSelect extends ActionVisitorTemplateStmt<StordiveInfo> {

	public StordiveVisiDaoSelect(DeciTreeOption<StordiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StordiveInfo> buildStmtExecHook(List<DaoStmtExecOption<StordiveInfo>> stmtOptions) {
		return new StordiveDaoSelect(stmtOptions);
	}
}
