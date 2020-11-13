package br.com.mind5.business.calendarWeekYear.model.action;

import java.util.List;

import br.com.mind5.business.calendarWeekYear.dao.DaoCaleekySelect;
import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCaleekyDaoSelect extends ActionVisitorTemplateStmt<CaleekyInfo> {

	public VisiCaleekyDaoSelect(DeciTreeOption<CaleekyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CaleekyInfo> buildStmtExecHook(List<DaoStmtExecOption<CaleekyInfo>> stmtOptions) {
		return new DaoCaleekySelect(stmtOptions);
	}
}
