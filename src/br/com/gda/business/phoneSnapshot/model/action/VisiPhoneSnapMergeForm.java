package br.com.gda.business.phoneSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.form.formPhone.model.decisionTree.RootFormPhoneSelect;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPhoneSnapMergeForm extends ActionVisitorTemplateMerge<PhoneSnapInfo, FormPhoneInfo> {
	
	public VisiPhoneSnapMergeForm(Connection conn, String schemaName) {
		super(conn, schemaName, FormPhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormPhoneInfo>> getTreeClassHook() {
		return RootFormPhoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PhoneSnapInfo>> getMergerClassHook() {
		return PhoneSnapMerger.class;
	}
}
