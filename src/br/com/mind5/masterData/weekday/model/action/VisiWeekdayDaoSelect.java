package br.com.mind5.masterData.weekday.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.weekday.dao.DaoWeekdaySelect;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiWeekdayDaoSelect extends ActionVisitorTemplateStmtV2<WeekdayInfo>{

	public VisiWeekdayDaoSelect(DeciTreeOption<WeekdayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<WeekdayInfo> buildStmtExecHook(List<DaoStmtExecOption<WeekdayInfo>> stmtOptions) {
		return new DaoWeekdaySelect(stmtOptions);
	}
}
