package br.com.gda.business.addressSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.info.AddressSnapMerger;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.form.formAddress.model.decisionTree.RootFormAddressSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiAddressSnapMergeForm extends ActionVisitorTemplateMerge<AddressSnapInfo, FormAddressInfo> {
	
	public VisiAddressSnapMergeForm(Connection conn, String schemaName) {
		super(conn, schemaName, FormAddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormAddressInfo>> getTreeClassHook() {
		return RootFormAddressSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<AddressSnapInfo>> getMergerClassHook() {
		return AddressSnapMerger.class;
	}
}
