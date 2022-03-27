package br.com.mind5.business.employeeWorkTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeSnapshot.dao.EmpwotmapDaoInsert;
import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmapVisiDaoInsert extends ActionVisitorTemplateStmt<EmpwotmapInfo> {

	public EmpwotmapVisiDaoInsert(DeciTreeOption<EmpwotmapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpwotmapInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpwotmapInfo>> stmtOptions) {
		return new EmpwotmapDaoInsert(stmtOptions);
	}
}
