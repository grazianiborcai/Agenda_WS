package br.com.mind5.masterData.cartItemCategorySearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.cartItemCategorySearch.dao.DaoCaritegarchSelect;
import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCaritegarchDaoSelect extends ActionVisitorTemplateStmt<CaritegarchInfo> {

	public VisiCaritegarchDaoSelect(DeciTreeOption<CaritegarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CaritegarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CaritegarchInfo>> stmtOptions) {
		return new DaoCaritegarchSelect(stmtOptions);
	}
}
