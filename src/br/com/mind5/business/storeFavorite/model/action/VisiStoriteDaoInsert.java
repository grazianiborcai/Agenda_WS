package br.com.mind5.business.storeFavorite.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavorite.dao.DaoStoriteInsert;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;

final class VisiStoriteDaoInsert extends ActionVisitorTemplateStmtV2<StoriteInfo> {

	public VisiStoriteDaoInsert(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StoriteInfo> buildStmtExecHook(List<DaoStmtExecOption<StoriteInfo>> stmtOptions) {
		return new DaoStoriteInsert(stmtOptions);
	}
}
