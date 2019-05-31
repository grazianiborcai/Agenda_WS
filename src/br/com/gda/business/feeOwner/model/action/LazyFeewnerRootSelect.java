package br.com.gda.business.feeOwner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.business.feeOwner.model.decisionTree.RootFeewnerSelect;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFeewnerRootSelect extends ActionLazyTemplate<FeewnerInfo, FeewnerInfo> {

	public LazyFeewnerRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FeewnerInfo> translateRecordInfosHook(List<FeewnerInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FeewnerInfo> getInstanceOfActionHook(DeciTreeOption<FeewnerInfo> option) {
		return new RootFeewnerSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FeewnerInfo> translateResultHook(DeciResult<FeewnerInfo> result) {
		return result;
	}
}
