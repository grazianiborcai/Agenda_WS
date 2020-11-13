package br.com.mind5.business.employeeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeSearch.dao.DaoEmparchSelect;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmparchDaoSelect extends ActionVisitorTemplateStmtV2<EmparchInfo> {

	public VisiEmparchDaoSelect(DeciTreeOption<EmparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmparchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmparchInfo>> stmtOptions) {
		return new DaoEmparchSelect(stmtOptions);
	}
}
