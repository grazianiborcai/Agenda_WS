package br.com.mind5.business.materialList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatlisMergeMatGroup extends ActionLazyTemplateV1<MatlisInfo, MatlisInfo> {
	
	public LazyMatlisMergeMatGroup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatlisInfo> translateRecordInfosHook(List<MatlisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatlisInfo> getInstanceOfActionHook(DeciTreeOption<MatlisInfo> option) {
		return new StdMatlisMergeMatGroup(option);
	}
	
	
	
	@Override protected DeciResult<MatlisInfo> translateResultHook(DeciResult<MatlisInfo> result) {
		return result;
	}
}
