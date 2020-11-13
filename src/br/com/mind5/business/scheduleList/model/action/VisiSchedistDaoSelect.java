package br.com.mind5.business.scheduleList.model.action;

import java.util.List;

import br.com.mind5.business.scheduleList.dao.DaoSchedistSelect;
import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedistDaoSelect extends ActionVisitorTemplateStmt<SchedistInfo> {

	public VisiSchedistDaoSelect(DeciTreeOption<SchedistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SchedistInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedistInfo>> stmtOptions) {
		return new DaoSchedistSelect(stmtOptions);
	}
}
