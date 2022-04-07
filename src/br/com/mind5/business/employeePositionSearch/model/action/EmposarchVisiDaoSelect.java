package br.com.mind5.business.employeePositionSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeePositionSearch.dao.EmposarchDaoSelect;
import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposarchVisiDaoSelect extends ActionVisitorTemplateStmt<EmposarchInfo> {

	public EmposarchVisiDaoSelect(DeciTreeOption<EmposarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmposarchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmposarchInfo>> stmtOptions) {
		return new EmposarchDaoSelect(stmtOptions);
	}
}
