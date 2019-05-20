package br.com.gda.business.phoneSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPhonapMergeForm extends ActionLazyTemplate<PhonapInfo, PhonapInfo> {
	
	public LazyPhonapMergeForm(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PhonapInfo> translateRecordInfosHook(List<PhonapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PhonapInfo> getInstanceOfActionHook(DeciTreeOption<PhonapInfo> option) {
		return new StdPhonapMergeForm(option);
	}
	
	
	
	@Override protected DeciResult<PhonapInfo> translateResultHook(DeciResult<PhonapInfo> result) {
		return result;
	}
}
