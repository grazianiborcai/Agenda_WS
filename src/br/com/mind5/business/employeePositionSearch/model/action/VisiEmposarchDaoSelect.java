package br.com.mind5.business.employeePositionSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeePositionSearch.dao.DaoEmposarchSelect;
import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposarchDaoSelect extends ActionVisitorTemplateStmt<EmposarchInfo> {

	public VisiEmposarchDaoSelect(DeciTreeOption<EmposarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmposarchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmposarchInfo>> stmtOptions) {
		return new DaoEmposarchSelect(stmtOptions);
	}
}
