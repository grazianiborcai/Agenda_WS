package br.com.mind5.masterData.dayPartingSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.dayPartingSearch.dao.DayparchDaoSelect;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DayparchVisiDaoSelect extends ActionVisitorTemplateStmt<DayparchInfo> {

	public DayparchVisiDaoSelect(DeciTreeOption<DayparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<DayparchInfo> buildStmtExecHook(List<DaoStmtExecOption<DayparchInfo>> stmtOptions) {
		return new DayparchDaoSelect(stmtOptions);
	}
}
