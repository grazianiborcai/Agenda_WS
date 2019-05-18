package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatsnapSelect;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyMatsnapRootSelect extends ActionLazyTemplate<MatsnapInfo, MatsnapInfo> {

	public LazyMatsnapRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatsnapInfo> translateRecordInfosHook(List<MatsnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MatsnapInfo> getInstanceOfActionHook(DeciTreeOption<MatsnapInfo> option) {
		return new RootMatsnapSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatsnapInfo> translateResultHook(DeciResult<MatsnapInfo> result) {
		return result;
	}
}
