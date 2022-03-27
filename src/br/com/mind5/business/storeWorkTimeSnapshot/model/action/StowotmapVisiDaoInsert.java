package br.com.mind5.business.storeWorkTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeSnapshot.dao.StowotmapDaoInsert;
import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmapVisiDaoInsert extends ActionVisitorTemplateStmt<StowotmapInfo> {

	public StowotmapVisiDaoInsert(DeciTreeOption<StowotmapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StowotmapInfo> buildStmtExecHook(List<DaoStmtExecOption<StowotmapInfo>> stmtOptions) {
		return new StowotmapDaoInsert(stmtOptions);
	}
}
