package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyOwnerMergeUsername extends ActionLazyTemplate<OwnerInfo, OwnerInfo> {
	
	public LazyOwnerMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OwnerInfo> translateRecordInfosHook(List<OwnerInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OwnerInfo> getInstanceOfActionHook(DeciTreeOption<OwnerInfo> option) {
		return new StdOwnerMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<OwnerInfo> translateResultHook(DeciResult<OwnerInfo> result) {
		return result;
	}
}
