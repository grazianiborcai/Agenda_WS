package br.com.mind5.business.materialSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialSearch.dao.DaoMatarchSelect;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatarchDaoSelect extends ActionVisitorTemplateStmt<MatarchInfo> {

	public VisiMatarchDaoSelect(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatarchInfo>> stmtOptions) {
		return new DaoMatarchSelect(stmtOptions);
	}

}
