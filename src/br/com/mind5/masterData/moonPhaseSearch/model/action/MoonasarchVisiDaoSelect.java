package br.com.mind5.masterData.moonPhaseSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.moonPhaseSearch.dao.MoonasarchDaoSelect;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MoonasarchVisiDaoSelect extends ActionVisitorTemplateStmt<MoonasarchInfo> {

	public MoonasarchVisiDaoSelect(DeciTreeOption<MoonasarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MoonasarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MoonasarchInfo>> stmtOptions) {
		return new MoonasarchDaoSelect(stmtOptions);
	}
}
