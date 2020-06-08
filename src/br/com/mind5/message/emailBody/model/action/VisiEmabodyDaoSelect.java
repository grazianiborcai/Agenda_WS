package br.com.mind5.message.emailBody.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.message.emailBody.dao.DaoEmabodySelect;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmabodyDaoSelect extends ActionVisitorTemplateStmtV2<EmabodyInfo> {

	public VisiEmabodyDaoSelect(DeciTreeOption<EmabodyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmabodyInfo> buildStmtExecHook(List<DaoStmtExecOption<EmabodyInfo>> stmtOptions) {
		return new DaoEmabodySelect(stmtOptions);
	}
}
