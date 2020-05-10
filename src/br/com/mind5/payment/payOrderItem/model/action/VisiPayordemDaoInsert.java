package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.dao.DaoPayordemInsert;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class VisiPayordemDaoInsert extends ActionVisitorTemplateStmtV2<PayordemInfo> {

	public VisiPayordemDaoInsert(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PayordemInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordemInfo>> stmtOptions) {
		return new DaoPayordemInsert(stmtOptions);
	}
}
