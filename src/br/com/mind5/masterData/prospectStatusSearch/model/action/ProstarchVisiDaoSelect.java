package br.com.mind5.masterData.prospectStatusSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.prospectStatusSearch.dao.ProstarchDaoSelect;
import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ProstarchVisiDaoSelect extends ActionVisitorTemplateStmt<ProstarchInfo> {

	public ProstarchVisiDaoSelect(DeciTreeOption<ProstarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<ProstarchInfo> buildStmtExecHook(List<DaoStmtExecOption<ProstarchInfo>> stmtOptions) {
		return new ProstarchDaoSelect(stmtOptions);
	}
}
