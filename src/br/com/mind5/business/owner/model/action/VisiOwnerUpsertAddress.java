package br.com.mind5.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressUpsertdel;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerUpsertAddress extends ActionVisitorTemplateAction<OwnerInfo, AddressInfo> {
	public VisiOwnerUpsertAddress(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return AddressCopier.copyFromOwner(recordInfos);
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getActionHook(DeciTreeOption<AddressInfo> option) {
		return new RootAddressUpsertdel(option).toAction();
	}
}
