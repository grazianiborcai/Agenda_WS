package br.com.mind5.business.employeeList.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.dao.DaoEmplisSelect;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplisDaoSelect extends ActionVisitorTemplateStmt<EmplisInfo> {

	public VisiEmplisDaoSelect(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmplisInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplisInfo>> stmtOptions) {
		return new DaoEmplisSelect(stmtOptions);
	}
}
