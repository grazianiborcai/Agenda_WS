package br.com.mind5.masterData.paymentStatus.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.paymentStatus.dao.DaoPaymenusSelect;
import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPaymenusDaoSelect extends ActionVisitorTemplateStmt<PaymenusInfo> {

	public VisiPaymenusDaoSelect(DeciTreeOption<PaymenusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PaymenusInfo> buildStmtExecHook(List<DaoStmtExecOption<PaymenusInfo>> stmtOptions) {
		return new DaoPaymenusSelect(stmtOptions);
	}
}
