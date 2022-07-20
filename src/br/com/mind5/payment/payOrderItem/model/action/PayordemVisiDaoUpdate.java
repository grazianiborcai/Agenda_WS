package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.dao.PayordemDaoUpdate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemVisiDaoUpdate extends ActionVisitorTemplateStmt<PayordemInfo> {

	public PayordemVisiDaoUpdate(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayordemInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordemInfo>> stmtOptions) {
		return new PayordemDaoUpdate(stmtOptions);
	}
}
