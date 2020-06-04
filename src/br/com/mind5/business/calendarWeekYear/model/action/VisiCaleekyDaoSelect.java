package br.com.mind5.business.calendarWeekYear.model.action;

import java.util.List;

import br.com.mind5.business.calendarWeekYear.dao.DaoCaleekySelect;
import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCaleekyDaoSelect extends ActionVisitorTemplateStmtV2<CaleekyInfo> {

	public VisiCaleekyDaoSelect(DeciTreeOption<CaleekyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CaleekyInfo> buildStmtExecHook(List<DaoStmtExecOption<CaleekyInfo>> stmtOptions) {
		return new DaoCaleekySelect(stmtOptions);
	}
}
