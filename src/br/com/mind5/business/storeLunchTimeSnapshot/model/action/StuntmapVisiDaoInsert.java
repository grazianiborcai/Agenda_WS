package br.com.mind5.business.storeLunchTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTimeSnapshot.dao.StuntmapDaoInsert;
import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmapVisiDaoInsert extends ActionVisitorTemplateStmt<StuntmapInfo> {

	public StuntmapVisiDaoInsert(DeciTreeOption<StuntmapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StuntmapInfo> buildStmtExecHook(List<DaoStmtExecOption<StuntmapInfo>> stmtOptions) {
		return new StuntmapDaoInsert(stmtOptions);
	}
}
