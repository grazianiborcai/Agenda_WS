package br.com.mind5.message.emailBody.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.message.emailBody.dao.DaoEmabodySelect;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmabodyDaoSelect extends ActionVisitorTemplateStmt<EmabodyInfo> {

	public VisiEmabodyDaoSelect(DeciTreeOption<EmabodyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmabodyInfo> buildStmtExecHook(List<DaoStmtExecOption<EmabodyInfo>> stmtOptions) {
		return new DaoEmabodySelect(stmtOptions);
	}
}
