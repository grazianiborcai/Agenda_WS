package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.dao.DaoPayordInsert;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class VisiPayordDaoInsert extends ActionVisitorTemplateStmtV2<PayordInfo> {

	public VisiPayordDaoInsert(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PayordInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordInfo>> stmtOptions) {
		return new DaoPayordInsert(stmtOptions);
	}
}
