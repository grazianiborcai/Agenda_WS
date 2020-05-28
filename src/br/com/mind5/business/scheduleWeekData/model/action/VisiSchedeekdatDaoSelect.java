package br.com.mind5.business.scheduleWeekData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleWeekData.dao.DaoSchedeekdatSelect;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedeekdatDaoSelect extends ActionVisitorTemplateStmtV2<SchedeekdatInfo> {

	public VisiSchedeekdatDaoSelect(DeciTreeOption<SchedeekdatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SchedeekdatInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedeekdatInfo>> stmtOptions) {
		return new DaoSchedeekdatSelect(stmtOptions);
	}
}
