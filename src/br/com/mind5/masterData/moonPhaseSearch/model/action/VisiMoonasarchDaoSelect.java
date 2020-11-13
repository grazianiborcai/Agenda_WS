package br.com.mind5.masterData.moonPhaseSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.moonPhaseSearch.dao.DaoMoonasarchSelect;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMoonasarchDaoSelect extends ActionVisitorTemplateStmt<MoonasarchInfo> {

	public VisiMoonasarchDaoSelect(DeciTreeOption<MoonasarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MoonasarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MoonasarchInfo>> stmtOptions) {
		return new DaoMoonasarchSelect(stmtOptions);
	}
}
