package br.com.mind5.business.scheduleMoviment.model.action;

import java.util.List;

import br.com.mind5.business.scheduleMoviment.dao.SchedovmDaoInsert;
import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedovmVisiDaoInsert extends ActionVisitorTemplateStmt<SchedovmInfo> {

	public SchedovmVisiDaoInsert(DeciTreeOption<SchedovmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedovmInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedovmInfo>> stmtOptions) {
		return new SchedovmDaoInsert(stmtOptions);
	}
}
