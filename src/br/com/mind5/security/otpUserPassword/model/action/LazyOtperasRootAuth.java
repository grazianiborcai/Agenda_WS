package br.com.mind5.security.otpUserPassword.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.decisionTree.RootOtperasAuthenticate;

public final class LazyOtperasRootAuth extends ActionLazyTemplate<OtperasInfo, OtperasInfo> {
	
	public LazyOtperasRootAuth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OtperasInfo> translateRecordInfosHook(List<OtperasInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OtperasInfo> getInstanceOfActionHook(DeciTreeOption<OtperasInfo> option) {
		return new RootOtperasAuthenticate(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OtperasInfo> translateResultHook(DeciResult<OtperasInfo> result) {
		return result;
	}
}
