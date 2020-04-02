package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressUpsertdel;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusUpsertAddress extends ActionVisitorTemplateAction<CusInfo, AddressInfo> {
	
	public VisiCusUpsertAddress(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<CusInfo> recordInfos) {
		return AddressCopier.copyFromCus(recordInfos);
	}
	
	
	
	@Override protected ActionStdV1<AddressInfo> getActionHook(DeciTreeOption<AddressInfo> option) {
		return new RootAddressUpsertdel(option).toAction();
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<AddressInfo> results) {
		return CusMerger.mergeWithAddress(results, baseInfos);
	}
}
