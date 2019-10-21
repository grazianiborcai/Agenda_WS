package br.com.mind5.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyAddressMergeUsername extends ActionLazyTemplate<AddressInfo, AddressInfo> {

	public LazyAddressMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AddressInfo> translateRecordInfosHook(List<AddressInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getInstanceOfActionHook(DeciTreeOption<AddressInfo> option) {
		return new StdAddressMergeUsername(option);
	}
	
	
	
	@Override protected DeciResult<AddressInfo> translateResultHook(DeciResult<AddressInfo> result) {
		return result;
	}
}
