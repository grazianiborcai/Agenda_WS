package br.com.mind5.business.refundPolicyStoreSearch.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.dao.RefuporarchDaoSelect;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporarchVisiDaoSelect extends ActionVisitorTemplateStmt<RefuporarchInfo> {

	public RefuporarchVisiDaoSelect(DeciTreeOption<RefuporarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefuporarchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefuporarchInfo>> stmtOptions) {
		return new RefuporarchDaoSelect(stmtOptions);
	}
}
