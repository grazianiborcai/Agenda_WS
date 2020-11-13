package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.dao.DaoRefupownDelete;
import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownDaoDelete extends ActionVisitorTemplateStmt<RefupownInfo> {

	public VisiRefupownDaoDelete(DeciTreeOption<RefupownInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefupownInfo> buildStmtExecHook(List<DaoStmtExecOption<RefupownInfo>> stmtOptions) {
		return new DaoRefupownDelete(stmtOptions);
	}
}
