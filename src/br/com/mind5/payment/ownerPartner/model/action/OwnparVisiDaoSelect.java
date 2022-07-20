package br.com.mind5.payment.ownerPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.dao.OwnparDaoSelect;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class OwnparVisiDaoSelect extends ActionVisitorTemplateStmt<OwnparInfo> {

	public OwnparVisiDaoSelect(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OwnparInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnparInfo>> stmtOptions) {
		return new OwnparDaoSelect(stmtOptions);
	}
}
