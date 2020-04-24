package br.com.mind5.masterData.weekdaySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.weekdaySearch.dao.DaoWeekdarchSelect;
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiWeekdarchDaoSelect extends ActionVisitorTemplateStmtV2<WeekdarchInfo>{

	public VisiWeekdarchDaoSelect(DeciTreeOption<WeekdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<WeekdarchInfo> buildStmtExecHook(List<DaoStmtExecOption<WeekdarchInfo>> stmtOptions) {
		return new DaoWeekdarchSelect(stmtOptions);
	}
}
