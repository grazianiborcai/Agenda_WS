package br.com.mind5.business.materialStock.model.action;

import java.util.List;

import br.com.mind5.business.materialStock.dao.DaoMatockLock;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatockDaoLock extends ActionVisitorTemplateStmt<MatockInfo> {

	public VisiMatockDaoLock(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatockInfo> buildStmtExecHook(List<DaoStmtExecOption<MatockInfo>> stmtOptions) {
		return new DaoMatockLock(stmtOptions);
	}
}
