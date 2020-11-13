package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.dao.DaoSchedineSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineDaoSelect extends ActionVisitorTemplateStmt<SchedineInfo> {

	public VisiSchedineDaoSelect(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedineInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedineInfo>> stmtOptions) {
		return new DaoSchedineSelect(stmtOptions);
	}
}
