package br.com.mind5.message.emailUserOtp.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailUserOtp.info.EmusotpInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmusotpSendEmail extends ActionLazyTemplateV2<EmusotpInfo, EmusotpInfo> {
	
	public LazyEmusotpSendEmail(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmusotpInfo> translateRecordInfosHook(List<EmusotpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmusotpInfo> getInstanceOfActionHook(DeciTreeOption<EmusotpInfo> option) {
		return new StdEmusotpSendEmail(option);
	}
	
	
	
	@Override protected DeciResult<EmusotpInfo> translateResultHook(DeciResult<EmusotpInfo> result) {
		return result;
	}
}
