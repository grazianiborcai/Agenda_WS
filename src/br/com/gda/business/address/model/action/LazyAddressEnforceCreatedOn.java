package br.com.gda.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyAddressEnforceCreatedOn extends ActionLazyTemplate<AddressInfo, AddressInfo> {

	public LazyAddressEnforceCreatedOn(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AddressInfo> translateRecordInfosHook(List<AddressInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getInstanceOfActionHook(DeciTreeOption<AddressInfo> option) {
		return new StdAddressEnforceCreatedOn(option);
	}
	
	
	
	@Override protected DeciResult<AddressInfo> translateResultHook(DeciResult<AddressInfo> result) {
		return result;
	}
}
