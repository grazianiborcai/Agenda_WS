package br.com.mind5.business.employeeMaterialSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.dao.DaoEmpmarchSelect;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpmarchDaoSelect extends ActionVisitorTemplateStmt<EmpmarchInfo> {

	public VisiEmpmarchDaoSelect(DeciTreeOption<EmpmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmpmarchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpmarchInfo>> stmtOptions) {
		return new DaoEmpmarchSelect(stmtOptions);
	}
}
