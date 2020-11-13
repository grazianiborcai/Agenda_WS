package br.com.mind5.business.scheduleYearData.model.action;

import java.util.List;

import br.com.mind5.business.scheduleYearData.dao.DaoSchedyeratSelect;
import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedyeratDaoSelect extends ActionVisitorTemplateStmt<SchedyeratInfo> {

	public VisiSchedyeratDaoSelect(DeciTreeOption<SchedyeratInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SchedyeratInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedyeratInfo>> stmtOptions) {
		return new DaoSchedyeratSelect(stmtOptions);
	}
}
