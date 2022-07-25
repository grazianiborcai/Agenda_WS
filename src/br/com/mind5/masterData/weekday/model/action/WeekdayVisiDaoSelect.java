package br.com.mind5.masterData.weekday.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.weekday.dao.WeekdayDaoSelect;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class WeekdayVisiDaoSelect extends ActionVisitorTemplateStmt<WeekdayInfo> {

	public WeekdayVisiDaoSelect(DeciTreeOption<WeekdayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<WeekdayInfo> buildStmtExecHook(List<DaoStmtExecOption<WeekdayInfo>> stmtOptions) {
		return new WeekdayDaoSelect(stmtOptions);
	}
}
