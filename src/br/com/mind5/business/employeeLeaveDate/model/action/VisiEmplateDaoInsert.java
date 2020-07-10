package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.dao.DaoEmplateInsert;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplateDaoInsert extends ActionVisitorTemplateStmtV2<EmplateInfo> {

	public VisiEmplateDaoInsert(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmplateInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplateInfo>> stmtOptions) {
		return new DaoEmplateInsert(stmtOptions);
	}
}
