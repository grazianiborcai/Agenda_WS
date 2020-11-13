package br.com.mind5.masterData.scheduleStatus.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.scheduleStatus.dao.DaoSchedatusSelect;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedatusDaoSelect extends ActionVisitorTemplateStmt<SchedatusInfo> {

	public VisiSchedatusDaoSelect(DeciTreeOption<SchedatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedatusInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedatusInfo>> stmtOptions) {
		return new DaoSchedatusSelect(stmtOptions);
	}
}
