package br.com.mind5.business.storeFavoriteSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavoriteSearch.dao.DaoStoritarchSelect;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;

final class VisiStoritarchDaoSelect extends ActionVisitorTemplateStmt<StoritarchInfo> {

	public VisiStoritarchDaoSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoritarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StoritarchInfo>> stmtOptions) {
		return new DaoStoritarchSelect(stmtOptions);
	}
}
