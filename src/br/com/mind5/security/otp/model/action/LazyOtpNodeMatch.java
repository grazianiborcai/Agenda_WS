package br.com.mind5.security.otp.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.decisionTree.NodeOtpMatch;

public final class LazyOtpNodeMatch extends ActionLazyTemplateV2<OtpInfo, OtpInfo> {
	
	public LazyOtpNodeMatch(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OtpInfo> translateRecordInfosHook(List<OtpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OtpInfo> getInstanceOfActionHook(DeciTreeOption<OtpInfo> option) {
		return new NodeOtpMatch(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OtpInfo> translateResultHook(DeciResult<OtpInfo> result) {
		return result;
	}
}
