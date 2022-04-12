package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.dao.RefuporeDaoUpdate;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeVisiDaoUpdate extends ActionVisitorTemplateStmt<RefuporeInfo> {

	public RefuporeVisiDaoUpdate(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefuporeInfo> buildStmtExecHook(List<DaoStmtExecOption<RefuporeInfo>> stmtOptions) {
		return new RefuporeDaoUpdate(stmtOptions);
	}
}
