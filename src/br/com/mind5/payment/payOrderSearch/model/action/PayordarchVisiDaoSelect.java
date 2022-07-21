package br.com.mind5.payment.payOrderSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.dao.PayordarchDaoSelect;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchVisiDaoSelect extends ActionVisitorTemplateStmt<PayordarchInfo> {

	public PayordarchVisiDaoSelect(DeciTreeOption<PayordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayordarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordarchInfo>> stmtOptions) {
		return new PayordarchDaoSelect(stmtOptions);
	}
}
