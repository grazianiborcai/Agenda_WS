package br.com.mind5.masterData.monthSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.monthSearch.dao.DaoMontharchSelect;
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMontharchDaoSelect extends ActionVisitorTemplateStmt<MontharchInfo> {

	public VisiMontharchDaoSelect(DeciTreeOption<MontharchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MontharchInfo> buildStmtExecHook(List<DaoStmtExecOption<MontharchInfo>> stmtOptions) {
		return new DaoMontharchSelect(stmtOptions);
	}
}
