package br.com.mind5.business.calendarDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.calendarDateSearch.dao.DaoCalatarchSelect;
import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalatarchDaoSelect extends ActionVisitorTemplateStmt<CalatarchInfo> {

	public VisiCalatarchDaoSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CalatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CalatarchInfo>> stmtOptions) {
		return new DaoCalatarchSelect(stmtOptions);
	}
}
