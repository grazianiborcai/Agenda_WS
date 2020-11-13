package br.com.mind5.payment.payOrderList.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.dao.DaoPayordistSelect;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

final class VisiPayordistDaoSelect extends ActionVisitorTemplateStmtV2<PayordistInfo> {

	public VisiPayordistDaoSelect(DeciTreeOption<PayordistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PayordistInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordistInfo>> stmtOptions) {
		return new DaoPayordistSelect(stmtOptions);
	}
}
