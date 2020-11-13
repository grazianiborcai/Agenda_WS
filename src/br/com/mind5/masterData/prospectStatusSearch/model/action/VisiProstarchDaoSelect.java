package br.com.mind5.masterData.prospectStatusSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.prospectStatusSearch.dao.DaoProstarchSelect;
import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiProstarchDaoSelect extends ActionVisitorTemplateStmt<ProstarchInfo> {

	public VisiProstarchDaoSelect(DeciTreeOption<ProstarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<ProstarchInfo> buildStmtExecHook(List<DaoStmtExecOption<ProstarchInfo>> stmtOptions) {
		return new DaoProstarchSelect(stmtOptions);
	}
}
