package br.com.mind5.masterData.timezoneSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.timezoneSearch.dao.TimezonarchDaoSelect;
import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class TimezonarchVisiDaoSelect extends ActionVisitorTemplateStmt<TimezonarchInfo> {

	public TimezonarchVisiDaoSelect(DeciTreeOption<TimezonarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<TimezonarchInfo> buildStmtExecHook(List<DaoStmtExecOption<TimezonarchInfo>> stmtOptions) {
		return new TimezonarchDaoSelect(stmtOptions);
	}
}
