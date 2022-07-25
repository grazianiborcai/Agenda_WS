package br.com.mind5.masterData.materialTypeSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialTypeSearch.dao.MatyparchDaoSelect;
import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatyparchVisiDaoSelect extends ActionVisitorTemplateStmt<MatyparchInfo> {

	public MatyparchVisiDaoSelect(DeciTreeOption<MatyparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatyparchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatyparchInfo>> stmtOptions) {
		return new MatyparchDaoSelect(stmtOptions);
	}
}
