package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.dao.DaoOtperasDelete;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

final class VisiOtperasDaoDelete extends ActionVisitorTemplateStmtV2<OtperasInfo> {

	public VisiOtperasDaoDelete(DeciTreeOption<OtperasInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OtperasInfo> buildStmtExecHook(List<DaoStmtExecOption<OtperasInfo>> stmtOptions) {
		return new DaoOtperasDelete(stmtOptions);
	}
}
