package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.dao.OtporeDaoInsert;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class OtporeVisiDaoInsert extends ActionVisitorTemplateStmt<OtporeInfo> {

	public OtporeVisiDaoInsert(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OtporeInfo> buildStmtExecHook(List<DaoStmtExecOption<OtporeInfo>> stmtOptions) {
		return new OtporeDaoInsert(stmtOptions);
	}
}
