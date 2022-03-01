package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.dao.SowordiveDaoSelect;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;

public final class SowordiveVisiDaoSelect extends ActionVisitorTemplateStmt<SowordiveInfo> {

	public SowordiveVisiDaoSelect(DeciTreeOption<SowordiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowordiveInfo> buildStmtExecHook(List<DaoStmtExecOption<SowordiveInfo>> stmtOptions) {
		return new SowordiveDaoSelect(stmtOptions);
	}
}
