package br.com.gda.business.phone.model.action;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.info.PhoneMerger;
import br.com.gda.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPhoneMergeToDelete extends ActionVisitorTemplateMerge<PhoneInfo, PhoneInfo> {
	
	public VisiPhoneMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PhoneInfo>> getMergerClassHook() {
		return PhoneMerger.class;
	}
}
