package br.com.mind5.payment.marketplacePartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.marketplacePartner.dao.MktparDaoSelect;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;

public final class MktparVisiDaoSelect extends ActionVisitorTemplateStmt<MktparInfo> {

	public MktparVisiDaoSelect(DeciTreeOption<MktparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MktparInfo> buildStmtExecHook(List<DaoStmtExecOption<MktparInfo>> stmtOptions) {
		return new MktparDaoSelect(stmtOptions);
	}
}
