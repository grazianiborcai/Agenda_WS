package br.com.mind5.security.userList.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.dao.DaoUselisSelect;
import br.com.mind5.security.userList.info.UselisInfo;

final class VisiUselisDaoSelect extends ActionVisitorTemplateStmtV2<UselisInfo> {

	public VisiUselisDaoSelect(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<UselisInfo> buildStmtExecHook(List<DaoStmtExecOption<UselisInfo>> stmtOptions) {
		return new DaoUselisSelect(stmtOptions);
	}
}
