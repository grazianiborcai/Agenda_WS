package br.com.mind5.message.email.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.message.email.dao.DaoEmailSelect;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmailDaoSelect extends ActionVisitorTemplateStmt<EmailInfo> {

	public VisiEmailDaoSelect(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmailInfo> buildStmtExecHook(List<DaoStmtExecOption<EmailInfo>> stmtOptions) {
		return new DaoEmailSelect(stmtOptions);
	}
}
