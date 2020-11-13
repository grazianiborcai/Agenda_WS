package br.com.mind5.webhook.moipMultipayment.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.dao.DaoWokaymoipSelect;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

final class VisiWokaymoipDaoSelect extends ActionVisitorTemplateStmt<WokaymoipInfo> {

	public VisiWokaymoipDaoSelect(DeciTreeOption<WokaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<WokaymoipInfo> buildStmtExecHook(List<DaoStmtExecOption<WokaymoipInfo>> stmtOptions) {
		return new DaoWokaymoipSelect(stmtOptions);
	}
}
