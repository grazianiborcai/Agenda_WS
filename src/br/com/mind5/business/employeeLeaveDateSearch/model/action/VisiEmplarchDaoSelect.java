package br.com.mind5.business.employeeLeaveDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.dao.DaoEmplarchSelect;
import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplarchDaoSelect extends ActionVisitorTemplateStmtV2<EmplarchInfo> {

	public VisiEmplarchDaoSelect(DeciTreeOption<EmplarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmplarchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplarchInfo>> stmtOptions) {
		return new DaoEmplarchSelect(stmtOptions);
	}
}
