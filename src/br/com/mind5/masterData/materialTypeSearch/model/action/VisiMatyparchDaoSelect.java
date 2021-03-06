package br.com.mind5.masterData.materialTypeSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialTypeSearch.dao.DaoMatyparchSelect;
import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatyparchDaoSelect extends ActionVisitorTemplateStmt<MatyparchInfo> {

	public VisiMatyparchDaoSelect(DeciTreeOption<MatyparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatyparchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatyparchInfo>> stmtOptions) {
		return new DaoMatyparchSelect(stmtOptions);
	}
}
