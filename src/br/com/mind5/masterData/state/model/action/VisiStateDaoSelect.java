package br.com.mind5.masterData.state.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.state.dao.DaoStateSelect;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStateDaoSelect extends ActionVisitorTemplateStmt<StateInfo> {

	public VisiStateDaoSelect(DeciTreeOption<StateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StateInfo> buildStmtExecHook(List<DaoStmtExecOption<StateInfo>> stmtOptions) {
		return new DaoStateSelect(stmtOptions);
	}
}
