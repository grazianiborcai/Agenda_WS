package br.com.mind5.business.storeProspectSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeProspectSearch.dao.DaoStoprarchSelect;
import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoprarchDaoSelect extends ActionVisitorTemplateStmt<StoprarchInfo> {

	public VisiStoprarchDaoSelect(DeciTreeOption<StoprarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoprarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StoprarchInfo>> stmtOptions) {
		return new DaoStoprarchSelect(stmtOptions);
	}
}
