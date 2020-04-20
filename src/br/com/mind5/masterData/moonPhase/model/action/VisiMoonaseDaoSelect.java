package br.com.mind5.masterData.moonPhase.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.moonPhase.dao.DaoMoonaseSelect;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMoonaseDaoSelect extends ActionVisitorTemplateStmtV2<MoonaseInfo>{

	public VisiMoonaseDaoSelect(DeciTreeOption<MoonaseInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MoonaseInfo> buildStmtExecHook(List<DaoStmtExecOption<MoonaseInfo>> stmtOptions) {
		return new DaoMoonaseSelect(stmtOptions);
	}
}
