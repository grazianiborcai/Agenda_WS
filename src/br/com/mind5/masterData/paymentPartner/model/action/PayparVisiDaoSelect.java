package br.com.mind5.masterData.paymentPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.paymentPartner.dao.PayparDaoSelect;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayparVisiDaoSelect extends ActionVisitorTemplateStmt<PayparInfo> {

	public PayparVisiDaoSelect(DeciTreeOption<PayparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PayparInfo> buildStmtExecHook(List<DaoStmtExecOption<PayparInfo>> stmtOptions) {
		return new PayparDaoSelect(stmtOptions);
	}
}
