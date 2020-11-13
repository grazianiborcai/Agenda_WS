package br.com.mind5.masterData.paymentPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.paymentPartner.dao.DaoPayparSelect;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPayparDaoSelect extends ActionVisitorTemplateStmt<PayparInfo> {

	public VisiPayparDaoSelect(DeciTreeOption<PayparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PayparInfo> buildStmtExecHook(List<DaoStmtExecOption<PayparInfo>> stmtOptions) {
		return new DaoPayparSelect(stmtOptions);
	}
}
