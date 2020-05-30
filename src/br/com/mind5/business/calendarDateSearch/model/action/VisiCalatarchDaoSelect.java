package br.com.mind5.business.calendarDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.calendarDateSearch.dao.DaoCalatarchSelect;
import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalatarchDaoSelect extends ActionVisitorTemplateStmtV2<CalatarchInfo> {

	public VisiCalatarchDaoSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CalatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CalatarchInfo>> stmtOptions) {
		return new DaoCalatarchSelect(stmtOptions);
	}
}
