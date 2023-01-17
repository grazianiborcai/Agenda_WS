package br.com.mind5.masterData.paymentPartnerDefault.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.paymentPartnerDefault.dao.PayparultDaoSelect;
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayparultVisiDaoSelect extends ActionVisitorTemplateStmt<PayparultInfo> {

	public PayparultVisiDaoSelect(DeciTreeOption<PayparultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayparultInfo> buildStmtExecHook(List<DaoStmtExecOption<PayparultInfo>> stmtOptions) {
		return new PayparultDaoSelect(stmtOptions);
	}
}
