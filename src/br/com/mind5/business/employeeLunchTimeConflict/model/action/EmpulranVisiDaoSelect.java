package br.com.mind5.business.employeeLunchTimeConflict.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeConflict.dao.EmpulranDaoSelect;
import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulranInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpulranVisiDaoSelect extends ActionVisitorTemplateStmt<EmpulranInfo> {

	public EmpulranVisiDaoSelect(DeciTreeOption<EmpulranInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpulranInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpulranInfo>> stmtOptions) {
		return new EmpulranDaoSelect(stmtOptions);
	}
}
