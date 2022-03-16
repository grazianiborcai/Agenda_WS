package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.storeList.dao.StolisDaoSelect;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolisVisiDaoSelect extends ActionVisitorTemplateStmt<StolisInfo> {

	public StolisVisiDaoSelect(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StolisInfo> buildStmtExecHook(List<DaoStmtExecOption<StolisInfo>> stmtOptions) {
		return new StolisDaoSelect(stmtOptions);
	}
}
