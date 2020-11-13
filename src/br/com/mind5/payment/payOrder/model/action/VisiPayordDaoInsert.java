package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.dao.DaoPayordInsert;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class VisiPayordDaoInsert extends ActionVisitorTemplateStmt<PayordInfo> {

	public VisiPayordDaoInsert(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayordInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordInfo>> stmtOptions) {
		return new DaoPayordInsert(stmtOptions);
	}
}
