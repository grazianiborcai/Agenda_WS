package br.com.mind5.payment.ownerPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.dao.DaoOwnparSelect;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

final class VisiOwnparDaoSelect extends ActionVisitorTemplateStmt<OwnparInfo> {

	public VisiOwnparDaoSelect(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OwnparInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnparInfo>> stmtOptions) {
		return new DaoOwnparSelect(stmtOptions);
	}
}
