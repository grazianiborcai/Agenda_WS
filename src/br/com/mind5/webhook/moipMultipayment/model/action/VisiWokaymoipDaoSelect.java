package br.com.mind5.webhook.moipMultipayment.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.dao.DaoWokaymoipSelect;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

final class VisiWokaymoipDaoSelect extends ActionVisitorTemplateStmtV2<WokaymoipInfo> {

	public VisiWokaymoipDaoSelect(DeciTreeOption<WokaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<WokaymoipInfo> buildStmtExecHook(List<DaoStmtExecOption<WokaymoipInfo>> stmtOptions) {
		return new DaoWokaymoipSelect(stmtOptions);
	}
}
