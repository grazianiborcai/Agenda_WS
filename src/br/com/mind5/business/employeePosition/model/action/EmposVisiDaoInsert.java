package br.com.mind5.business.employeePosition.model.action;

import java.util.List;

import br.com.mind5.business.employeePosition.dao.EmposDaoInsert;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposVisiDaoInsert extends ActionVisitorTemplateStmt<EmposInfo> {

	public EmposVisiDaoInsert(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmposInfo> buildStmtExecHook(List<DaoStmtExecOption<EmposInfo>> stmtOptions) {
		return new EmposDaoInsert(stmtOptions);
	}
}
