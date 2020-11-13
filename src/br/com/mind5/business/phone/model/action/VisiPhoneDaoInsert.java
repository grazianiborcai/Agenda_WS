package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.dao.DaoPhoneInsert;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhoneDaoInsert extends ActionVisitorTemplateStmt<PhoneInfo> {

	public VisiPhoneDaoInsert(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PhoneInfo> buildStmtExecHook(List<DaoStmtExecOption<PhoneInfo>> stmtOptions) {
		return new DaoPhoneInsert(stmtOptions);
	}
}
