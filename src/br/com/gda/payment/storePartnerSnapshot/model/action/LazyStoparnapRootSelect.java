package br.com.gda.payment.storePartnerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.gda.payment.storePartnerSnapshot.model.decisionTree.RootStoparnapSelect;

public final class LazyStoparnapRootSelect extends ActionLazyTemplate<StoparnapInfo, StoparnapInfo> {
	
	public LazyStoparnapRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoparnapInfo> translateRecordInfosHook(List<StoparnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoparnapInfo> getInstanceOfActionHook(DeciTreeOption<StoparnapInfo> option) {
		return new RootStoparnapSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoparnapInfo> translateResultHook(DeciResult<StoparnapInfo> result) {
		return result;
	}
}
