package br.com.gda.business.addressSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.model.decisionTree.NodeAddressSnapInsertL2;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyAddressSnapNodeInsertL2 extends ActionLazyTemplate<AddressSnapInfo, AddressSnapInfo> {
	
	public LazyAddressSnapNodeInsertL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AddressSnapInfo> translateRecordInfosHook(List<AddressSnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<AddressSnapInfo> getInstanceOfActionHook(DeciTreeOption<AddressSnapInfo> option) {
		return new NodeAddressSnapInsertL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<AddressSnapInfo> translateResultHook(DeciResult<AddressSnapInfo> result) {
		return result;
	}
}
