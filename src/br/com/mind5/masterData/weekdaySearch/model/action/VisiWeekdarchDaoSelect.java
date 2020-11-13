package br.com.mind5.masterData.weekdaySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.weekdaySearch.dao.DaoWeekdarchSelect;
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiWeekdarchDaoSelect extends ActionVisitorTemplateStmt<WeekdarchInfo> {

	public VisiWeekdarchDaoSelect(DeciTreeOption<WeekdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<WeekdarchInfo> buildStmtExecHook(List<DaoStmtExecOption<WeekdarchInfo>> stmtOptions) {
		return new DaoWeekdarchSelect(stmtOptions);
	}
}
