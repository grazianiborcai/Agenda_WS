package br.com.gda.business.phone.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.form.formPhone.model.decisionTree.RootFormPhoneSelect;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.info.PhoneMerger;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPhoneMergeForm extends ActionVisitorTemplateMerge<PhoneInfo, FormPhoneInfo> {
	
	public VisiPhoneMergeForm(Connection conn, String schemaName) {
		super(conn, schemaName, FormPhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormPhoneInfo>> getTreeClassHook() {
		return RootFormPhoneSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> mergeHook(List<PhoneInfo> recordInfos, List<FormPhoneInfo> selectedInfos) {	
		return PhoneMerger.mergeWithForm(selectedInfos, recordInfos);
	}
}
