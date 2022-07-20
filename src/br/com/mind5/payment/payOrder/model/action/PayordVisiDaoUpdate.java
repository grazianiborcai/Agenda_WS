package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.dao.PayordDaoUpdate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordVisiDaoUpdate extends ActionVisitorTemplateStmt<PayordInfo> {

	public PayordVisiDaoUpdate(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayordInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordInfo>> stmtOptions) {
		return new PayordDaoUpdate(stmtOptions);
	}
}
