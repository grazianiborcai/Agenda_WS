package br.com.mind5.message.sysMessage.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.message.sysMessage.dao.SymsgDaoSelect;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SymsgVisiDaoSelect extends ActionVisitorTemplateStmt<SymsgInfo> {

	public SymsgVisiDaoSelect(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SymsgInfo> buildStmtExecHook(List<DaoStmtExecOption<SymsgInfo>> stmtOptions) {
		return new SymsgDaoSelect(stmtOptions);
	}
}
