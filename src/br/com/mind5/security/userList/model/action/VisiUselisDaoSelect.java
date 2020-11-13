package br.com.mind5.security.userList.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.dao.DaoUselisSelect;
import br.com.mind5.security.userList.info.UselisInfo;

final class VisiUselisDaoSelect extends ActionVisitorTemplateStmt<UselisInfo> {

	public VisiUselisDaoSelect(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<UselisInfo> buildStmtExecHook(List<DaoStmtExecOption<UselisInfo>> stmtOptions) {
		return new DaoUselisSelect(stmtOptions);
	}
}
