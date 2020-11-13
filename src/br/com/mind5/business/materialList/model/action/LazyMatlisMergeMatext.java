package br.com.mind5.business.materialList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatlisMergeMatext extends ActionLazyTemplate<MatlisInfo, MatlisInfo> {
	
	public LazyMatlisMergeMatext(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatlisInfo> translateRecordInfosHook(List<MatlisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatlisInfo> getInstanceOfActionHook(DeciTreeOption<MatlisInfo> option) {
		return new StdMatlisMergeMatext(option);
	}
	
	
	
	@Override protected DeciResult<MatlisInfo> translateResultHook(DeciResult<MatlisInfo> result) {
		return result;
	}
}
