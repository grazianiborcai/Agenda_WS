package br.com.mind5.masterData.stateSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.stateSearch.dao.DaoStatarchSelect;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStatarchDaoSelect extends ActionVisitorTemplateStmtV2<StatarchInfo> {

	public VisiStatarchDaoSelect(DeciTreeOption<StatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StatarchInfo>> stmtOptions) {
		return new DaoStatarchSelect(stmtOptions);
	}
}
