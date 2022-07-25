package br.com.mind5.masterData.stateSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.stateSearch.dao.StatarchDaoSelect;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StatarchVisiDaoSelect extends ActionVisitorTemplateStmt<StatarchInfo> {

	public StatarchVisiDaoSelect(DeciTreeOption<StatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<StatarchInfo>> stmtOptions) {
		return new StatarchDaoSelect(stmtOptions);
	}
}
