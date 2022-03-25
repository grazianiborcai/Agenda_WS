package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.dao.EmpwoutDaoSelect;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwoutVisiDaoSelect extends ActionVisitorTemplateStmt<EmpwoutInfo> {

	public EmpwoutVisiDaoSelect(DeciTreeOption<EmpwoutInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpwoutInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpwoutInfo>> stmtOptions) {
		return new EmpwoutDaoSelect(stmtOptions);
	}
}
