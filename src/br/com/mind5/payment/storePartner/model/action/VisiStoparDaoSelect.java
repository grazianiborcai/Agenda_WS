package br.com.mind5.payment.storePartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.dao.DaoStoparSelect;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class VisiStoparDaoSelect extends ActionVisitorTemplateStmtV2<StoparInfo> {

	public VisiStoparDaoSelect(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StoparInfo> buildStmtExecHook(List<DaoStmtExecOption<StoparInfo>> stmtOptions) {
		return new DaoStoparSelect(stmtOptions);
	}
}
