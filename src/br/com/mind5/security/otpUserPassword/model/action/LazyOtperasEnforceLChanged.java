package br.com.mind5.security.otpUserPassword.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class LazyOtperasEnforceLChanged extends ActionLazyTemplate<OtperasInfo, OtperasInfo> {
	
	public LazyOtperasEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OtperasInfo> translateRecordInfosHook(List<OtperasInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OtperasInfo> getInstanceOfActionHook(DeciTreeOption<OtperasInfo> option) {
		return new StdOtperasEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<OtperasInfo> translateResultHook(DeciResult<OtperasInfo> result) {
		return result;
	}
}
