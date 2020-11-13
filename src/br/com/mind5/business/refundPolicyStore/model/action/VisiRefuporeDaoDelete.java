package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.dao.DaoRefuporeDelete;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporeDaoDelete extends ActionVisitorTemplateStmt<RefuporeInfo> {

	public VisiRefuporeDaoDelete(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefuporeInfo> buildStmtExecHook(List<DaoStmtExecOption<RefuporeInfo>> stmtOptions) {
		return new DaoRefuporeDelete(stmtOptions);
	}
}
