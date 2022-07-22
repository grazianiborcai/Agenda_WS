package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.dao.StoparnapDaoInsert;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StoparnapVisiDaoInsert extends ActionVisitorTemplateStmt<StoparnapInfo> {

	public StoparnapVisiDaoInsert(DeciTreeOption<StoparnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoparnapInfo> buildStmtExecHook(List<DaoStmtExecOption<StoparnapInfo>> stmtOptions) {
		return new StoparnapDaoInsert(stmtOptions);
	}
}
