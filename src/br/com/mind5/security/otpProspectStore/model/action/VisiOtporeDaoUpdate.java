package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.dao.DaoOtporeUpdate;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

final class VisiOtporeDaoUpdate extends ActionVisitorTemplateStmtV2<OtporeInfo> {

	public VisiOtporeDaoUpdate(DeciTreeOption<OtporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OtporeInfo> buildStmtExecHook(List<DaoStmtExecOption<OtporeInfo>> stmtOptions) {
		return new DaoOtporeUpdate(stmtOptions);
	}
}
