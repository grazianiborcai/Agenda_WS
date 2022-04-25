package br.com.mind5.business.employeeLunchTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeSearch.dao.EmplutmarchDaoSelect;
import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmarchVisiDaoSelect extends ActionVisitorTemplateStmt<EmplutmarchInfo> {

	public EmplutmarchVisiDaoSelect(DeciTreeOption<EmplutmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmplutmarchInfo> buildStmtExecHook(List<DaoStmtExecOption<EmplutmarchInfo>> stmtOptions) {
		return new EmplutmarchDaoSelect(stmtOptions);
	}
}
