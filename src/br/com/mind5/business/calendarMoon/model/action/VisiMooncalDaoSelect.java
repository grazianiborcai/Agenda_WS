package br.com.mind5.business.calendarMoon.model.action;

import java.util.List;

import br.com.mind5.business.calendarMoon.dao.DaoMooncalSelect;
import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMooncalDaoSelect extends ActionVisitorTemplateStmt<MooncalInfo> {

	public VisiMooncalDaoSelect(DeciTreeOption<MooncalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MooncalInfo> buildStmtExecHook(List<DaoStmtExecOption<MooncalInfo>> stmtOptions) {
		return new DaoMooncalSelect(stmtOptions);
	}
}
