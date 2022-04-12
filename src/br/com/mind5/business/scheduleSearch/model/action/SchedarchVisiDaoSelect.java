package br.com.mind5.business.scheduleSearch.model.action;

import java.util.List;

import br.com.mind5.business.scheduleSearch.dao.SchedarchDaoSelect;
import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedarchVisiDaoSelect extends ActionVisitorTemplateStmt<SchedarchInfo> {

	public SchedarchVisiDaoSelect(DeciTreeOption<SchedarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedarchInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedarchInfo>> stmtOptions) {
		return new SchedarchDaoSelect(stmtOptions);
	}
}
