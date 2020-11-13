package br.com.mind5.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatsnapMergeMatubup extends ActionLazyTemplate<MatsnapInfo, MatsnapInfo> {
	
	public LazyMatsnapMergeMatubup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatsnapInfo> translateRecordInfosHook(List<MatsnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatsnapInfo> getInstanceOfActionHook(DeciTreeOption<MatsnapInfo> option) {
		return new StdMatsnapMergeMatubup(option);
	}
	
	
	
	@Override protected DeciResult<MatsnapInfo> translateResultHook(DeciResult<MatsnapInfo> result) {
		return result;
	}
}
