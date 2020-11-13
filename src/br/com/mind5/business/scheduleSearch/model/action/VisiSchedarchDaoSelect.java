package br.com.mind5.business.scheduleSearch.model.action;

import java.util.List;

import br.com.mind5.business.scheduleSearch.dao.DaoSchedarchSelect;
import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedarchDaoSelect extends ActionVisitorTemplateStmt<SchedarchInfo> {

	public VisiSchedarchDaoSelect(DeciTreeOption<SchedarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SchedarchInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedarchInfo>> stmtOptions) {
		return new DaoSchedarchSelect(stmtOptions);
	}
}
