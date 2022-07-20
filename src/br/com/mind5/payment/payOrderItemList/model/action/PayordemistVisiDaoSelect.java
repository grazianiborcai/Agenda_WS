package br.com.mind5.payment.payOrderItemList.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.dao.PayordemistDaoSelect;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class PayordemistVisiDaoSelect extends ActionVisitorTemplateStmt<PayordemistInfo> {

	public PayordemistVisiDaoSelect(DeciTreeOption<PayordemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayordemistInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordemistInfo>> stmtOptions) {
		return new PayordemistDaoSelect(stmtOptions);
	}
}
