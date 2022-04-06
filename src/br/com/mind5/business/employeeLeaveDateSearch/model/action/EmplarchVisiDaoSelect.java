package br.com.mind5.business.employeeLeaveDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.dao.EmplarchDaoSelect;
import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplarchVisiDaoSelect extends ActionVisitorTemplateStmt<EmplarchInfo> {

	public EmplarchVisiDaoSelect(DeciTreeOption<EmplarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmplarchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplarchInfo>> stmtOptions) {
		return new EmplarchDaoSelect(stmtOptions);
	}
}
