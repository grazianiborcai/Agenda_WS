package br.com.mind5.message.sysMessage.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.message.sysMessage.dao.DaoSymsgSelect;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSymsgDaoSelect extends ActionVisitorTemplateStmt<SymsgInfo> {

	public VisiSymsgDaoSelect(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SymsgInfo> buildStmtExecHook(List<DaoStmtExecOption<SymsgInfo>> stmtOptions) {
		return new DaoSymsgSelect(stmtOptions);
	}
}
