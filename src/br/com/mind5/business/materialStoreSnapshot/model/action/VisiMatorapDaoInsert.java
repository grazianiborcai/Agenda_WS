package br.com.mind5.business.materialStoreSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.dao.DaoMatorapInsert;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatorapDaoInsert extends ActionVisitorTemplateStmt<MatorapInfo> {

	public VisiMatorapDaoInsert(DeciTreeOption<MatorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatorapInfo> buildStmtExecHook(List<DaoStmtExecOption<MatorapInfo>> stmtOptions) {
		return new DaoMatorapInsert(stmtOptions);
	}
}
