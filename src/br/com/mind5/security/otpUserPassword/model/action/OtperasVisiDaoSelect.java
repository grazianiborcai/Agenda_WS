package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.dao.OtperasDaoSelect;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class OtperasVisiDaoSelect extends ActionVisitorTemplateStmt<OtperasInfo> {

	public OtperasVisiDaoSelect(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OtperasInfo> buildStmtExecHook(List<DaoStmtExecOption<OtperasInfo>> stmtOptions) {
		return new OtperasDaoSelect(stmtOptions);
	}
}
