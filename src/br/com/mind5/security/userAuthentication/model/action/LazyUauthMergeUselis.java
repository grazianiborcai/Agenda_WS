package br.com.mind5.security.userAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class LazyUauthMergeUselis extends ActionLazyTemplateV1<UauthInfo, UauthInfo> {
	
	public LazyUauthMergeUselis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UauthInfo> translateRecordInfosHook(List<UauthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<UauthInfo> getInstanceOfActionHook(DeciTreeOption<UauthInfo> option) {
		return new StdUauthMergeUselis(option);
	}
	
	
	
	@Override protected DeciResult<UauthInfo> translateResultHook(DeciResult<UauthInfo> result) {
		return result;
	}
}
