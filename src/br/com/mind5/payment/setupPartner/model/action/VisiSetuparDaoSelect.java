package br.com.mind5.payment.setupPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.dao.DaoSetuparSelect;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class VisiSetuparDaoSelect extends ActionVisitorTemplateStmt<SetuparInfo> {

	public VisiSetuparDaoSelect(DeciTreeOption<SetuparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SetuparInfo> buildStmtExecHook(List<DaoStmtExecOption<SetuparInfo>> stmtOptions) {
		return new DaoSetuparSelect(stmtOptions);
	}
}
