package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.dao.OtporeDaoDelete;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class OtporeVisiDaoDelete extends ActionVisitorTemplateStmt<OtporeInfo> {

	public OtporeVisiDaoDelete(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OtporeInfo> buildStmtExecHook(List<DaoStmtExecOption<OtporeInfo>> stmtOptions) {
		return new OtporeDaoDelete(stmtOptions);
	}
}
