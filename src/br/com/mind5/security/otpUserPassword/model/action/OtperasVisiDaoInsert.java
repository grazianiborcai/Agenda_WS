package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.dao.OtperasDaoInsert;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class OtperasVisiDaoInsert extends ActionVisitorTemplateStmt<OtperasInfo> {

	public OtperasVisiDaoInsert(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OtperasInfo> buildStmtExecHook(List<DaoStmtExecOption<OtperasInfo>> stmtOptions) {
		return new OtperasDaoInsert(stmtOptions);
	}
}
