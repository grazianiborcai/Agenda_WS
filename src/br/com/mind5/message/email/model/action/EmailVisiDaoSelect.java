package br.com.mind5.message.email.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.message.email.dao.EmailDaoSelect;
import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmailVisiDaoSelect extends ActionVisitorTemplateStmt<EmailInfo> {

	public EmailVisiDaoSelect(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmailInfo> buildStmtExecHook(List<DaoStmtExecOption<EmailInfo>> stmtOptions) {
		return new EmailDaoSelect(stmtOptions);
	}
}
