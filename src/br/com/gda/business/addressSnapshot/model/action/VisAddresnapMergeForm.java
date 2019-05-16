package br.com.gda.business.addressSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.info.AddresnapMerger;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.form.formAddress.model.decisionTree.RootFormAddressSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisAddresnapMergeForm extends ActionVisitorTemplateMergeV2<AddresnapInfo, FormAddressInfo> {
	
	public VisAddresnapMergeForm(Connection conn, String schemaName) {
		super(conn, schemaName, FormAddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormAddressInfo>> getTreeClassHook() {
		return RootFormAddressSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> recordInfos, List<FormAddressInfo> selectedInfos) {	
		return AddresnapMerger.mergeWithForm(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
