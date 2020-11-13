package br.com.mind5.business.scheduleMonthData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleMonthData.dao.DaoSchedonthatSelect;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedonthatDaoSelect extends ActionVisitorTemplateStmt<SchedonthatInfo> {

	public VisiSchedonthatDaoSelect(DeciTreeOption<SchedonthatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SchedonthatInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedonthatInfo>> stmtOptions) {
		return new DaoSchedonthatSelect(stmtOptions);
	}
}
