package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.dao.DaoOwnerInsert;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerDaoInsert extends ActionVisitorTemplateStmt<OwnerInfo> {

	public VisiOwnerDaoInsert(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OwnerInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnerInfo>> stmtOptions) {
		return new DaoOwnerInsert(stmtOptions);
	}
}
