package br.com.mind5.business.employeeWorkTimeRange.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.dao.EmpworgDaoSelect;
import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpworgVisiDaoSelect extends ActionVisitorTemplateStmt<EmpworgInfo> {

	public EmpworgVisiDaoSelect(DeciTreeOption<EmpworgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpworgInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpworgInfo>> stmtOptions) {
		return new EmpworgDaoSelect(stmtOptions);
	}
}
