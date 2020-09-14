package br.com.mind5.business.storeFavoriteSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavoriteSearch.dao.DaoStoritarchSelect;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;

final class VisiStoritarchDaoSelect extends ActionVisitorTemplateStmtV2<StoritarchInfo> {

	public VisiStoritarchDaoSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StoritarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StoritarchInfo>> stmtOptions) {
		return new DaoStoritarchSelect(stmtOptions);
	}
}
