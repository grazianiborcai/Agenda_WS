package br.com.mind5.business.storeWorkTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.dao.DaoStowotarchSelect;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStowotarchDaoSelect extends ActionVisitorTemplateStmt<StowotarchInfo> {

	public VisiStowotarchDaoSelect(DeciTreeOption<StowotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StowotarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StowotarchInfo>> stmtOptions) {
		return new DaoStowotarchSelect(stmtOptions);
	}
}
