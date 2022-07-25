package br.com.mind5.masterData.paymentStatus.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.paymentStatus.dao.PaymenusDaoSelect;
import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PaymenusVisiDaoSelect extends ActionVisitorTemplateStmt<PaymenusInfo> {

	public PaymenusVisiDaoSelect(DeciTreeOption<PaymenusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PaymenusInfo> buildStmtExecHook(List<DaoStmtExecOption<PaymenusInfo>> stmtOptions) {
		return new PaymenusDaoSelect(stmtOptions);
	}
}
