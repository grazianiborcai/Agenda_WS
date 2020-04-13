package br.com.mind5.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneMerger;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.model.decisionTree.RootFormoneSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPhoneMergeFormone extends ActionVisitorTemplateMergeV1<PhoneInfo, FormoneInfo> {
	
	public VisiPhoneMergeFormone(Connection conn, String schemaName) {
		super(conn, schemaName, FormoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormoneInfo>> getTreeClassHook() {
		return RootFormoneSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> recordInfos, List<FormoneInfo> selectedInfos) {	
		return PhoneMerger.mergeWithFormone(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
