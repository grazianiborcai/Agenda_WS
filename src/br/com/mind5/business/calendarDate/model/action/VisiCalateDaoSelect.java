package br.com.mind5.business.calendarDate.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.dao.DaoCalateSelect;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalateDaoSelect extends ActionVisitorTemplateStmtV2<CalateInfo> {

	public VisiCalateDaoSelect(DeciTreeOption<CalateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CalateInfo> buildStmtExecHook(List<DaoStmtExecOption<CalateInfo>> stmtOptions) {
		return new DaoCalateSelect(stmtOptions);
	}
}
