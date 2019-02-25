package br.com.gda.security.tokenAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;

public final class LazyTauthMergeUsername extends ActionLazyTemplate<TauthInfo, TauthInfo> {
	
	public LazyTauthMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<TauthInfo> translateRecordInfosHook(List<TauthInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<TauthInfo> getInstanceOfActionHook(DeciTreeOption<TauthInfo> option) {
		return new StdTauthMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<TauthInfo> translateResultHook(DeciResult<TauthInfo> result) {
		return result;
	}
}
