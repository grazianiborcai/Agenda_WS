package br.com.mind5.masterData.monthSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.monthSearch.dao.DaoMontharchSelect;
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMontharchDaoSelect extends ActionVisitorTemplateStmt<MontharchInfo> {

	public VisiMontharchDaoSelect(DeciTreeOption<MontharchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MontharchInfo> buildStmtExecHook(List<DaoStmtExecOption<MontharchInfo>> stmtOptions) {
		return new DaoMontharchSelect(stmtOptions);
	}
}
