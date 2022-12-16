package br.com.mind5.payment.marketplacePartnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.marketplacePartnerSearch.dao.MktpararchDaoSelect;
import br.com.mind5.payment.marketplacePartnerSearch.info.MktpararchInfo;

public final class MktpararchVisiDaoSelect extends ActionVisitorTemplateStmt<MktpararchInfo> {

	public MktpararchVisiDaoSelect(DeciTreeOption<MktpararchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MktpararchInfo> buildStmtExecHook(List<DaoStmtExecOption<MktpararchInfo>> stmtOptions) {
		return new MktpararchDaoSelect(stmtOptions);
	}
}
