package br.com.mind5.masterData.materialGroupSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialGroupSearch.dao.DaoMatouparchSelect;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatouparchDaoSelect extends ActionVisitorTemplateStmt<MatouparchInfo> {

	public VisiMatouparchDaoSelect(DeciTreeOption<MatouparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatouparchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatouparchInfo>> stmtOptions) {
		return new DaoMatouparchSelect(stmtOptions);
	}
}
