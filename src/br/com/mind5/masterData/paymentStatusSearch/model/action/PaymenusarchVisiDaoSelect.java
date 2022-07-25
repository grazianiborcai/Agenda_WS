package br.com.mind5.masterData.paymentStatusSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.paymentStatusSearch.dao.PaymenusarchDaoSelect;
import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PaymenusarchVisiDaoSelect extends ActionVisitorTemplateStmt<PaymenusarchInfo> {

	public PaymenusarchVisiDaoSelect(DeciTreeOption<PaymenusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PaymenusarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PaymenusarchInfo>> stmtOptions) {
		return new PaymenusarchDaoSelect(stmtOptions);
	}
}
