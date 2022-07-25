package br.com.mind5.masterData.moonPhase.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.moonPhase.dao.MoonaseDaoSelect;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MoonaseVisiDaoSelect extends ActionVisitorTemplateStmt<MoonaseInfo> {

	public MoonaseVisiDaoSelect(DeciTreeOption<MoonaseInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MoonaseInfo> buildStmtExecHook(List<DaoStmtExecOption<MoonaseInfo>> stmtOptions) {
		return new MoonaseDaoSelect(stmtOptions);
	}
}
