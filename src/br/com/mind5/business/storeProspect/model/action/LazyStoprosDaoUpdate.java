package br.com.mind5.business.storeProspect.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyStoprosDaoUpdate extends ActionLazyTemplateV2<StoprosInfo, StoprosInfo> {

	public LazyStoprosDaoUpdate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoprosInfo> translateRecordInfosHook(List<StoprosInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<StoprosInfo> getInstanceOfActionHook(DeciTreeOption<StoprosInfo> option) {
		return new StdStoprosDaoUpdate(option);
	}
	
	
	
	@Override protected DeciResult<StoprosInfo> translateResultHook(DeciResult<StoprosInfo> result) {
		return result;
	}
}
