package br.com.mind5.security.otpProspectStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class LazyOtporeEnforceValidUntil extends ActionLazyTemplate<OtporeInfo, OtporeInfo> {
	
	public LazyOtporeEnforceValidUntil(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OtporeInfo> translateRecordInfosHook(List<OtporeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OtporeInfo> getInstanceOfActionHook(DeciTreeOption<OtporeInfo> option) {
		return new StdOtporeEnforceValidUntil(option);
	}
	
	
	
	@Override protected DeciResult<OtporeInfo> translateResultHook(DeciResult<OtporeInfo> result) {
		return result;
	}
}
