package br.com.mind5.business.scheduleRange.model.action;

import java.util.List;

import br.com.mind5.business.scheduleRange.dao.DaoSchedageSelect;
import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedageDaoSelect extends ActionVisitorTemplateStmt<SchedageInfo> {

	public VisiSchedageDaoSelect(DeciTreeOption<SchedageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedageInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedageInfo>> stmtOptions) {
		return new DaoSchedageSelect(stmtOptions);
	}
}
