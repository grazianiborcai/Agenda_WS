package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.dao.StorbyDaoSelect;
import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiDaoSelect extends ActionVisitorTemplateStmt<StorbyInfo> {

	public StorbyVisiDaoSelect(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StorbyInfo> buildStmtExecHook(List<DaoStmtExecOption<StorbyInfo>> stmtOptions) {
		return new StorbyDaoSelect(stmtOptions);
	}
}
