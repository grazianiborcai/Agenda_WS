package br.com.mind5.business.scheduleList.model.action;

import java.util.List;

import br.com.mind5.business.scheduleList.dao.SchedistDaoSelect;
import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedistVisiDaoSelect extends ActionVisitorTemplateStmt<SchedistInfo> {

	public SchedistVisiDaoSelect(DeciTreeOption<SchedistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedistInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedistInfo>> stmtOptions) {
		return new SchedistDaoSelect(stmtOptions);
	}
}
