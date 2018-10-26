package br.com.gda.business.address.model.action;

import java.sql.Connection;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.info.AddressMerger;
import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.business.form.model.decisionTree.RootAddressFormSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiAddressMergeAddressForm extends ActionVisitorTemplateMerge<AddressInfo, AddressFormInfo> {
	
	public VisiAddressMergeAddressForm(Connection conn, String schemaName) {
		super(conn, schemaName, AddressFormInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressFormInfo>> getTreeClassHook() {
		return RootAddressFormSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<AddressInfo>> getMergerClassHook() {
		return AddressMerger.class;
	}
}
