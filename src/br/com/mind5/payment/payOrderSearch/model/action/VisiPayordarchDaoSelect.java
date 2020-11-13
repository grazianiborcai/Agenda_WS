package br.com.mind5.payment.payOrderSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.dao.DaoPayordarchSelect;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

final class VisiPayordarchDaoSelect extends ActionVisitorTemplateStmt<PayordarchInfo> {

	public VisiPayordarchDaoSelect(DeciTreeOption<PayordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayordarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordarchInfo>> stmtOptions) {
		return new DaoPayordarchSelect(stmtOptions);
	}
}
