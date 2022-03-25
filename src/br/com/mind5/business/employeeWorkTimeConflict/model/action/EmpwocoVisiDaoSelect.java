package br.com.mind5.business.employeeWorkTimeConflict.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.dao.EmpwocoDaoSelect;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwocoVisiDaoSelect extends ActionVisitorTemplateStmt<EmpwocoInfo> {

	public EmpwocoVisiDaoSelect(DeciTreeOption<EmpwocoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpwocoInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpwocoInfo>> stmtOptions) {
		return new EmpwocoDaoSelect(stmtOptions);
	}
}
