package br.com.mind5.masterData.monthSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.monthSearch.dao.MontharchDaoSelect;
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MontharchVisiDaoSelect extends ActionVisitorTemplateStmt<MontharchInfo> {

	public MontharchVisiDaoSelect(DeciTreeOption<MontharchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MontharchInfo> buildStmtExecHook(List<DaoStmtExecOption<MontharchInfo>> stmtOptions) {
		return new MontharchDaoSelect(stmtOptions);
	}
}
