package br.com.mind5.security.tokenAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;

public final class LazyTauthMergeUsername extends ActionLazyTemplateV1<TauthInfo, TauthInfo> {
	
	public LazyTauthMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<TauthInfo> translateRecordInfosHook(List<TauthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<TauthInfo> getInstanceOfActionHook(DeciTreeOption<TauthInfo> option) {
		return new StdTauthMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<TauthInfo> translateResultHook(DeciResult<TauthInfo> result) {
		return result;
	}
}
