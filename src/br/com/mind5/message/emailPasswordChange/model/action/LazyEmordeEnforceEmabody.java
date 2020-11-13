package br.com.mind5.message.emailPasswordChange.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmordeEnforceEmabody extends ActionLazyTemplate<EmordeInfo, EmordeInfo> {
	
	public LazyEmordeEnforceEmabody(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmordeInfo> translateRecordInfosHook(List<EmordeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<EmordeInfo> getInstanceOfActionHook(DeciTreeOption<EmordeInfo> option) {
		return new StdEmordeEnforceEmabody(option);
	}
	
	
	
	@Override protected DeciResult<EmordeInfo> translateResultHook(DeciResult<EmordeInfo> result) {
		return result;
	}
}
