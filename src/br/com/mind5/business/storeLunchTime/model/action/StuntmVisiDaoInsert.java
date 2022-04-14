package br.com.mind5.business.storeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTime.dao.StuntmDaoInsert;
import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiDaoInsert extends ActionVisitorTemplateStmt<StuntmInfo> {

	public StuntmVisiDaoInsert(DeciTreeOption<StuntmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StuntmInfo> buildStmtExecHook(List<DaoStmtExecOption<StuntmInfo>> stmtOptions) {
		return new StuntmDaoInsert(stmtOptions);
	}
}
