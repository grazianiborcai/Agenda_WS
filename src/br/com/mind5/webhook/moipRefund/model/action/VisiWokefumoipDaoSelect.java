package br.com.mind5.webhook.moipRefund.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.dao.DaoWokefumoipSelect;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

final class VisiWokefumoipDaoSelect extends ActionVisitorTemplateStmt<WokefumoipInfo> {

	public VisiWokefumoipDaoSelect(DeciTreeOption<WokefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<WokefumoipInfo> buildStmtExecHook(List<DaoStmtExecOption<WokefumoipInfo>> stmtOptions) {
		return new DaoWokefumoipSelect(stmtOptions);
	}
}
