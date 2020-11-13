package br.com.mind5.business.calendarDate.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.dao.DaoCalateSelect;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalateDaoSelect extends ActionVisitorTemplateStmt<CalateInfo> {

	public VisiCalateDaoSelect(DeciTreeOption<CalateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CalateInfo> buildStmtExecHook(List<DaoStmtExecOption<CalateInfo>> stmtOptions) {
		return new DaoCalateSelect(stmtOptions);
	}
}
