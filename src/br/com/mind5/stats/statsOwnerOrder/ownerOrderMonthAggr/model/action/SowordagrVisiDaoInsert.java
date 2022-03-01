package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.dao.SowordagrDaoInsert;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;

public final class SowordagrVisiDaoInsert extends ActionVisitorTemplateStmt<SowordagrInfo> {

	public SowordagrVisiDaoInsert(DeciTreeOption<SowordagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowordagrInfo> buildStmtExecHook(List<DaoStmtExecOption<SowordagrInfo>> stmtOptions) {
		return new SowordagrDaoInsert(stmtOptions);
	}
}
