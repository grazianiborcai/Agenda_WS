package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.dao.DaoStoroniveSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;

final class VisiStoroniveDaoSelect extends ActionVisitorTemplateStmt<StoroniveInfo> {

	public VisiStoroniveDaoSelect(DeciTreeOption<StoroniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoroniveInfo> buildStmtExecHook(List<DaoStmtExecOption<StoroniveInfo>> stmtOptions) {
		return new DaoStoroniveSelect(stmtOptions);
	}
}
