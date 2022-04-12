package br.com.mind5.business.scheduleRange.model.action;

import java.util.List;

import br.com.mind5.business.scheduleRange.dao.SchedageDaoSelect;
import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedageVisiDaoSelect extends ActionVisitorTemplateStmt<SchedageInfo> {

	public SchedageVisiDaoSelect(DeciTreeOption<SchedageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedageInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedageInfo>> stmtOptions) {
		return new SchedageDaoSelect(stmtOptions);
	}
}
