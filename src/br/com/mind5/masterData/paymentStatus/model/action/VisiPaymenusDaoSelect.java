package br.com.mind5.masterData.paymentStatus.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.paymentStatus.dao.DaoPaymenusSelect;
import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPaymenusDaoSelect extends ActionVisitorTemplateStmtV2<PaymenusInfo> {

	public VisiPaymenusDaoSelect(DeciTreeOption<PaymenusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PaymenusInfo> buildStmtExecHook(List<DaoStmtExecOption<PaymenusInfo>> stmtOptions) {
		return new DaoPaymenusSelect(stmtOptions);
	}
}
