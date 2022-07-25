package br.com.mind5.masterData.petWeightSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.petWeightSearch.dao.PeteightarchDaoSelect;
import br.com.mind5.masterData.petWeightSearch.info.PeteightarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeteightarchVisiDaoSelect extends ActionVisitorTemplateStmt<PeteightarchInfo> {

	public PeteightarchVisiDaoSelect(DeciTreeOption<PeteightarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PeteightarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PeteightarchInfo>> stmtOptions) {
		return new PeteightarchDaoSelect(stmtOptions);
	}
}
