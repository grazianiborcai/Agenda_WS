package br.com.mind5.business.storeLeaveDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.dao.StolarchDaoSelect;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolarchVisiDaoSelect extends ActionVisitorTemplateStmt<StolarchInfo> {

	public StolarchVisiDaoSelect(DeciTreeOption<StolarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StolarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StolarchInfo>> stmtOptions) {
		return new StolarchDaoSelect(stmtOptions);
	}
}
