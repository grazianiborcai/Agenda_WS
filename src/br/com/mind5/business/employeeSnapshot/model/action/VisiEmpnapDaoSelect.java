package br.com.mind5.business.employeeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeSnapshot.dao.DaoEmpnapSelect;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpnapDaoSelect extends ActionVisitorTemplateStmtV2<EmpnapInfo> {

	public VisiEmpnapDaoSelect(DeciTreeOption<EmpnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmpnapInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpnapInfo>> stmtOptions) {
		return new DaoEmpnapSelect(stmtOptions);
	}
}
