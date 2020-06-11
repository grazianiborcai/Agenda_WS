package br.com.mind5.security.otpProspectStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.decisionTree.RootOtporeAuthenticate;

public final class LazyUpswdRootAuth extends ActionLazyTemplateV2<OtporeInfo, OtporeInfo> {
	
	public LazyUpswdRootAuth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OtporeInfo> translateRecordInfosHook(List<OtporeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OtporeInfo> getInstanceOfActionHook(DeciTreeOption<OtporeInfo> option) {
		return new RootOtporeAuthenticate(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OtporeInfo> translateResultHook(DeciResult<OtporeInfo> result) {
		return result;
	}
}