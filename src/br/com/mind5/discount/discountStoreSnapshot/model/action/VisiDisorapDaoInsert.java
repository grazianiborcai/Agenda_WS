package br.com.mind5.discount.discountStoreSnapshot.model.action;

import java.util.List;

import br.com.mind5.discount.discountStoreSnapshot.dao.DaoDisorapInsert;
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisorapDaoInsert extends ActionVisitorTemplateStmt<DisorapInfo> {

	public VisiDisorapDaoInsert(DeciTreeOption<DisorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<DisorapInfo> buildStmtExecHook(List<DaoStmtExecOption<DisorapInfo>> stmtOptions) {
		return new DaoDisorapInsert(stmtOptions);
	}
}
