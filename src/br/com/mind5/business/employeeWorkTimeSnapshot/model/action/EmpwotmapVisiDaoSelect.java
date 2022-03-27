package br.com.mind5.business.employeeWorkTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeSnapshot.dao.EmpwotmapDaoSelect;
import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmapVisiDaoSelect extends ActionVisitorTemplateStmt<EmpwotmapInfo> {

	public EmpwotmapVisiDaoSelect(DeciTreeOption<EmpwotmapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpwotmapInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpwotmapInfo>> stmtOptions) {
		return new EmpwotmapDaoSelect(stmtOptions);
	}
}
