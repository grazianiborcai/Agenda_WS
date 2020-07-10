package br.com.mind5.payment.payOrderItemSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.dao.DaoPayormarchSelect;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

final class VisiPayormarchDaoSelect extends ActionVisitorTemplateStmtV2<PayormarchInfo> {

	public VisiPayormarchDaoSelect(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PayormarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PayormarchInfo>> stmtOptions) {
		return new DaoPayormarchSelect(stmtOptions);
	}
}
