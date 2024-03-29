package br.com.mind5.payment.payOrderItemSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.dao.PayormarchDaoSelect;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class PayormarchVisiDaoSelect extends ActionVisitorTemplateStmt<PayormarchInfo> {

	public PayormarchVisiDaoSelect(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayormarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PayormarchInfo>> stmtOptions) {
		return new PayormarchDaoSelect(stmtOptions);
	}
}
