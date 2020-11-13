package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.dao.DaoStoparnapSelect;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

final class VisiStoparnapDaoSelect extends ActionVisitorTemplateStmt<StoparnapInfo> {

	public VisiStoparnapDaoSelect(DeciTreeOption<StoparnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoparnapInfo> buildStmtExecHook(List<DaoStmtExecOption<StoparnapInfo>> stmtOptions) {
		return new DaoStoparnapSelect(stmtOptions);
	}
}
