package br.com.mind5.business.storeProspectSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeProspectSearch.dao.DaoStoprarchSelect;
import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoprarchDaoSelect extends ActionVisitorTemplateStmtV2<StoprarchInfo>{

	public VisiStoprarchDaoSelect(DeciTreeOption<StoprarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StoprarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StoprarchInfo>> stmtOptions) {
		return new DaoStoprarchSelect(stmtOptions);
	}
}
