package br.com.mind5.business.storeFavoriteSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeFavoriteSearch.dao.StoritarchDaoSelect;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoritarchVisiDaoSelect extends ActionVisitorTemplateStmt<StoritarchInfo> {

	public StoritarchVisiDaoSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StoritarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StoritarchInfo>> stmtOptions) {
		return new StoritarchDaoSelect(stmtOptions);
	}
}
