package br.com.mind5.masterData.month.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.month.dao.MonthDaoSelect;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MonthVisiDaoSelect extends ActionVisitorTemplateStmt<MonthInfo> {

	public MonthVisiDaoSelect(DeciTreeOption<MonthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MonthInfo> buildStmtExecHook(List<DaoStmtExecOption<MonthInfo>> stmtOptions) {
		return new MonthDaoSelect(stmtOptions);
	}
}
