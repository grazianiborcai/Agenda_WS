package br.com.mind5.business.addressSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapMerger;
import br.com.mind5.business.form.formAddress.info.FormessInfo;
import br.com.mind5.business.form.formAddress.model.decisionTree.RootFormessSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisAddresnapMergeForm extends ActionVisitorTemplateMergeV1<AddresnapInfo, FormessInfo> {
	
	public VisAddresnapMergeForm(Connection conn, String schemaName) {
		super(conn, schemaName, FormessInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormessInfo>> getTreeClassHook() {
		return RootFormessSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> recordInfos, List<FormessInfo> selectedInfos) {	
		return AddresnapMerger.mergeWithForm(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
