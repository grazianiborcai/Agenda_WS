package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.dao.DaoEmplateSelect;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplateDaoSelect extends ActionVisitorTemplateStmtV2<EmplateInfo> {

	public VisiEmplateDaoSelect(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmplateInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplateInfo>> stmtOptions) {
		return new DaoEmplateSelect(stmtOptions);
	}
}
