package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.dao.StusorygrDaoSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;

public final class StusorygrVisiDaoSelect extends ActionVisitorTemplateStmt<StusorygrInfo> {

	public StusorygrVisiDaoSelect(DeciTreeOption<StusorygrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorygrInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorygrInfo>> stmtOptions) {
		return new StusorygrDaoSelect(stmtOptions);
	}
}
