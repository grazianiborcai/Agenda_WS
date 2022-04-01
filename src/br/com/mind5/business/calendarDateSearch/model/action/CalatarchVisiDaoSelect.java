package br.com.mind5.business.calendarDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.calendarDateSearch.dao.CalatarchDaoSelect;
import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalatarchVisiDaoSelect extends ActionVisitorTemplateStmt<CalatarchInfo> {

	public CalatarchVisiDaoSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CalatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CalatarchInfo>> stmtOptions) {
		return new CalatarchDaoSelect(stmtOptions);
	}
}
