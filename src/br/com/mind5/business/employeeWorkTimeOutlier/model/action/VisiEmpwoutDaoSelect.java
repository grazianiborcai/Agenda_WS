package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.dao.DaoEmpwoutSelect;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwoutDaoSelect extends ActionVisitorTemplateStmt<EmpwoutInfo> {

	public VisiEmpwoutDaoSelect(DeciTreeOption<EmpwoutInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmpwoutInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpwoutInfo>> stmtOptions) {
		return new DaoEmpwoutSelect(stmtOptions);
	}
}
