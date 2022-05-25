package br.com.mind5.business.storeManager.model.action;

import java.util.List;

import br.com.mind5.business.storeManager.dao.StomanDaoSelect;
import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StomanVisiDaoSelect extends ActionVisitorTemplateStmt<StomanInfo> {

	public StomanVisiDaoSelect(DeciTreeOption<StomanInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StomanInfo> buildStmtExecHook(List<DaoStmtExecOption<StomanInfo>> stmtOptions) {
		return new StomanDaoSelect(stmtOptions);
	}
}
