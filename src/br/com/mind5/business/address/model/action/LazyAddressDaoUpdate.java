package br.com.mind5.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyAddressDaoUpdate extends ActionLazyTemplateV2<AddressInfo, AddressInfo> {

	public LazyAddressDaoUpdate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AddressInfo> translateRecordInfosHook(List<AddressInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<AddressInfo> getInstanceOfActionHook(DeciTreeOption<AddressInfo> option) {
		return new StdAddressDaoUpdate(option);
	}
	
	
	
	@Override protected DeciResult<AddressInfo> translateResultHook(DeciResult<AddressInfo> result) {
		return result;
	}
}