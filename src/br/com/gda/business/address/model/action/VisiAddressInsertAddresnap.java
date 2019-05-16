package br.com.gda.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.info.AddressMerger;
import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.model.decisionTree.RootAddresnapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
