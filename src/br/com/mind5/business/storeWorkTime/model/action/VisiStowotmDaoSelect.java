package br.com.mind5.business.storeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTime.dao.DaoStowotmSelect;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStowotmDaoSelect extends ActionVisitorTemplateStmt<StowotmInfo> {

	public VisiStowotmDaoSelect(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StowotmInfo> buildStmtExecHook(List<DaoStmtExecOption<StowotmInfo>> stmtOptions) {
		return new DaoStowotmSelect(stmtOptions);
	}
}
