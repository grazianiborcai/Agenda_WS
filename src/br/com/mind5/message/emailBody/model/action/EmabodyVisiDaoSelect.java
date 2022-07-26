package br.com.mind5.message.emailBody.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.message.emailBody.dao.EmabodyDaoSelect;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmabodyVisiDaoSelect extends ActionVisitorTemplateStmt<EmabodyInfo> {

	public EmabodyVisiDaoSelect(DeciTreeOption<EmabodyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmabodyInfo> buildStmtExecHook(List<DaoStmtExecOption<EmabodyInfo>> stmtOptions) {
		return new EmabodyDaoSelect(stmtOptions);
	}
}
