package br.com.mind5.business.storeWorkTimeRange.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.dao.StoworgDaoSelect;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoworgVisiDaoSelect extends ActionVisitorTemplateStmt<StoworgInfo> {

	public StoworgVisiDaoSelect(DeciTreeOption<StoworgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoworgInfo> buildStmtExecHook(List<DaoStmtExecOption<StoworgInfo>> stmtOptions) {
		return new StoworgDaoSelect(stmtOptions);
	}
}
