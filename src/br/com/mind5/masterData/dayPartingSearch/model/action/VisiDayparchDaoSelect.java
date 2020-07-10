package br.com.mind5.masterData.dayPartingSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.dayPartingSearch.dao.DaoDayparchSelect;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDayparchDaoSelect extends ActionVisitorTemplateStmtV2<DayparchInfo> {

	public VisiDayparchDaoSelect(DeciTreeOption<DayparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<DayparchInfo> buildStmtExecHook(List<DaoStmtExecOption<DayparchInfo>> stmtOptions) {
		return new DaoDayparchSelect(stmtOptions);
	}
}
