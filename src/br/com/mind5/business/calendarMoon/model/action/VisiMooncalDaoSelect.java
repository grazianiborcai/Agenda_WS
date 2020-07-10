package br.com.mind5.business.calendarMoon.model.action;

import java.util.List;

import br.com.mind5.business.calendarMoon.dao.DaoMooncalSelect;
import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMooncalDaoSelect extends ActionVisitorTemplateStmtV2<MooncalInfo> {

	public VisiMooncalDaoSelect(DeciTreeOption<MooncalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MooncalInfo> buildStmtExecHook(List<DaoStmtExecOption<MooncalInfo>> stmtOptions) {
		return new DaoMooncalSelect(stmtOptions);
	}
}
