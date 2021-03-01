package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.dao.DaoStusorygrSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;

final class VisiStusorygrDaoSelect extends ActionVisitorTemplateStmt<StusorygrInfo> {

	public VisiStusorygrDaoSelect(DeciTreeOption<StusorygrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorygrInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorygrInfo>> stmtOptions) {
		return new DaoStusorygrSelect(stmtOptions);
	}
}
