package br.com.mind5.business.scheduleWeekData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleWeekData.dao.SchedeekdatDaoSelect;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekdatVisiDaoSelect extends ActionVisitorTemplateStmt<SchedeekdatInfo> {

	public SchedeekdatVisiDaoSelect(DeciTreeOption<SchedeekdatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedeekdatInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedeekdatInfo>> stmtOptions) {
		return new SchedeekdatDaoSelect(stmtOptions);
	}
}
