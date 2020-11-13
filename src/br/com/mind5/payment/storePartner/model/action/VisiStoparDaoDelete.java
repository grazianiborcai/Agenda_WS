package br.com.mind5.payment.storePartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.dao.DaoStoparDelete;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class VisiStoparDaoDelete extends ActionVisitorTemplateStmt<StoparInfo> {

	public VisiStoparDaoDelete(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoparInfo> buildStmtExecHook(List<DaoStmtExecOption<StoparInfo>> stmtOptions) {
		return new DaoStoparDelete(stmtOptions);
	}
}
