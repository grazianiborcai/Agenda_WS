package br.com.mind5.payment.payOrderSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.dao.DaoPayordarchSelect;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

final class VisiPayordarchDaoSelect extends ActionVisitorTemplateStmtV2<PayordarchInfo> {

	public VisiPayordarchDaoSelect(DeciTreeOption<PayordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PayordarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PayordarchInfo>> stmtOptions) {
		return new DaoPayordarchSelect(stmtOptions);
	}
}
