package br.com.mind5.business.calendarDate.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.dao.CalateDaoSelect;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalateVisiDaoSelect extends ActionVisitorTemplateStmt<CalateInfo> {

	public CalateVisiDaoSelect(DeciTreeOption<CalateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CalateInfo> buildStmtExecHook(List<DaoStmtExecOption<CalateInfo>> stmtOptions) {
		return new CalateDaoSelect(stmtOptions);
	}
}
