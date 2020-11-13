package br.com.mind5.masterData.paymentStatusSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.paymentStatusSearch.dao.DaoPaymenusarchSelect;
import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPaymenusarchDaoSelect extends ActionVisitorTemplateStmt<PaymenusarchInfo> {

	public VisiPaymenusarchDaoSelect(DeciTreeOption<PaymenusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PaymenusarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PaymenusarchInfo>> stmtOptions) {
		return new DaoPaymenusarchSelect(stmtOptions);
	}
}
