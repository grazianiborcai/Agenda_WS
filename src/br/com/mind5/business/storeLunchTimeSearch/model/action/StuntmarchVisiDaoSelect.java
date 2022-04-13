package br.com.mind5.business.storeLunchTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTimeSearch.dao.StuntmarchDaoSelect;
import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmarchVisiDaoSelect extends ActionVisitorTemplateStmt<StuntmarchInfo> {

	public StuntmarchVisiDaoSelect(DeciTreeOption<StuntmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StuntmarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StuntmarchInfo>> stmtOptions) {
		return new StuntmarchDaoSelect(stmtOptions);
	}
}
