package br.com.gda.business.ownerStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyOwntoreDeleteStore extends ActionLazyTemplate<OwntoreInfo, OwntoreInfo> {
	
	public LazyOwntoreDeleteStore(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwntoreInfo> translateRecordInfosHook(List<OwntoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OwntoreInfo> getInstanceOfActionHook(DeciTreeOption<OwntoreInfo> option) {
		return new StdOwntoreDeleteStore(option);
	}
	
	
	
	@Override protected DeciResult<OwntoreInfo> translateResultHook(DeciResult<OwntoreInfo> result) {
		return result;
	}
}
