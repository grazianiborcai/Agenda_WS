package br.com.mind5.security.otp.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;

public final class LazyOtpEnforceSalt extends ActionLazyTemplate<OtpInfo, OtpInfo> {
	
	public LazyOtpEnforceSalt(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OtpInfo> translateRecordInfosHook(List<OtpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OtpInfo> getInstanceOfActionHook(DeciTreeOption<OtpInfo> option) {
		return new StdOtpEnforceSalt(option);
	}
	
	
	
	@Override protected DeciResult<OtpInfo> translateResultHook(DeciResult<OtpInfo> result) {
		return result;
	}
}
