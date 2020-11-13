package br.com.mind5.business.refundPolicyStoreSearch.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.dao.DaoRefuporarchSelect;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporarchDaoSelect extends ActionVisitorTemplateStmt<RefuporarchInfo> {

	public VisiRefuporarchDaoSelect(DeciTreeOption<RefuporarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<RefuporarchInfo> buildStmtExecHook(List<DaoStmtExecOption<RefuporarchInfo>> stmtOptions) {
		return new DaoRefuporarchSelect(stmtOptions);
	}
}
