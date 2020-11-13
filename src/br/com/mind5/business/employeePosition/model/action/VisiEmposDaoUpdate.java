package br.com.mind5.business.employeePosition.model.action;

import java.util.List;

import br.com.mind5.business.employeePosition.dao.DaoEmposUpdate;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposDaoUpdate extends ActionVisitorTemplateStmt<EmposInfo> {

	public VisiEmposDaoUpdate(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmposInfo> buildStmtExecHook(List<DaoStmtExecOption<EmposInfo>> stmtOptions) {
		return new DaoEmposUpdate(stmtOptions);
	}
}
