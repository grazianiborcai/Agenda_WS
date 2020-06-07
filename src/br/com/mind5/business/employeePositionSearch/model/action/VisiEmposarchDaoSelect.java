package br.com.mind5.business.employeePositionSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeePositionSearch.dao.DaoEmposarchSelect;
import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposarchDaoSelect extends ActionVisitorTemplateStmtV2<EmposarchInfo> {

	public VisiEmposarchDaoSelect(DeciTreeOption<EmposarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmposarchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmposarchInfo>> stmtOptions) {
		return new DaoEmposarchSelect(stmtOptions);
	}
}
