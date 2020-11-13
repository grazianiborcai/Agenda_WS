package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.dao.DaoStorbySelect;
import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorbyDaoSelect extends ActionVisitorTemplateStmt<StorbyInfo> {

	public VisiStorbyDaoSelect(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StorbyInfo> buildStmtExecHook(List<DaoStmtExecOption<StorbyInfo>> stmtOptions) {
		return new DaoStorbySelect(stmtOptions);
	}
}
