package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSnapshot.dao.OrdemrapDaoInsert;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemrapVisiDaoInsert extends ActionVisitorTemplateStmt<OrdemrapInfo> {

	public OrdemrapVisiDaoInsert(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrdemrapInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdemrapInfo>> stmtOptions) {
		return new OrdemrapDaoInsert(stmtOptions);
	}
}
