package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.dao.DaoSchedineUpdate;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineDaoUpdate extends ActionVisitorTemplateStmt<SchedineInfo> {

	public VisiSchedineDaoUpdate(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedineInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedineInfo>> stmtOptions) {
		return new DaoSchedineUpdate(stmtOptions);
	}
}
