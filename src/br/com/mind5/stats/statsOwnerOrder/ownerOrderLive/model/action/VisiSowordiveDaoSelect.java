package br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.dao.DaoSowordiveSelect;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderLive.info.SowordiveInfo;

final class VisiSowordiveDaoSelect extends ActionVisitorTemplateStmt<SowordiveInfo> {

	public VisiSowordiveDaoSelect(DeciTreeOption<SowordiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SowordiveInfo> buildStmtExecHook(List<DaoStmtExecOption<SowordiveInfo>> stmtOptions) {
		return new DaoSowordiveSelect(stmtOptions);
	}
}
