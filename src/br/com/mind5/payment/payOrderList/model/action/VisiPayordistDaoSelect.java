package br.com.mind5.payment.payOrderList.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.dao.DaoPayordistSelect;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

final class VisiPayordistDaoSelect extends ActionVisitorTemplateStmt<PayordistInfo> {

	public VisiPayordistDaoSelect(DeciTreeOption<PayordistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayordistInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordistInfo>> stmtOptions) {
		return new DaoPayordistSelect(stmtOptions);
	}
}
