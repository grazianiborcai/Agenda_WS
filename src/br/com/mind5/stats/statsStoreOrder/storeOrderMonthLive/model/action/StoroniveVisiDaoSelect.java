package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.dao.StoroniveDaoSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;

public final class StoroniveVisiDaoSelect extends ActionVisitorTemplateStmt<StoroniveInfo> {

	public StoroniveVisiDaoSelect(DeciTreeOption<StoroniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoroniveInfo> buildStmtExecHook(List<DaoStmtExecOption<StoroniveInfo>> stmtOptions) {
		return new StoroniveDaoSelect(stmtOptions);
	}
}
