package br.com.mind5.business.scheduleMonthData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleMonthData.dao.SchedonthatDaoSelect;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedonthatVisiDaoSelect extends ActionVisitorTemplateStmt<SchedonthatInfo> {

	public SchedonthatVisiDaoSelect(DeciTreeOption<SchedonthatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedonthatInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedonthatInfo>> stmtOptions) {
		return new SchedonthatDaoSelect(stmtOptions);
	}
}
