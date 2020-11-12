package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.dao.DaoStoparnapInsert;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

final class VisiStoparnapDaoInsert extends ActionVisitorTemplateStmtV2<StoparnapInfo> {

	public VisiStoparnapDaoInsert(DeciTreeOption<StoparnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StoparnapInfo> buildStmtExecHook(List<DaoStmtExecOption<StoparnapInfo>> stmtOptions) {
		return new DaoStoparnapInsert(stmtOptions);
	}
}