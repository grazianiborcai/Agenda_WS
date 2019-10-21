package br.com.mind5.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.RootAddresnapInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressInsertAddresnap extends ActionVisitorTemplateAction<AddressInfo, AddresnapInfo> {

	public VisiAddressInsertAddresnap(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class, AddresnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddresnapInfo> getActionHook(DeciTreeOption<AddresnapInfo> option) {
		return new RootAddresnapInsert(option).toAction();
	}
	
	
	
	protected List<AddressInfo> toBaseClassHook(List<AddressInfo> baseInfos, List<AddresnapInfo> results) {
		return AddressMerger.mergeWithAddresnap(results, baseInfos);
	}
}
