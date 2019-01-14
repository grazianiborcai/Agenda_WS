package br.com.gda.business.phoneSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPhoneSnapMergePhone extends ActionVisitorTemplateMerge<PhoneSnapInfo, PhoneInfo> {
	
	public VisiPhoneSnapMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PhoneSnapInfo>> getMergerClassHook() {
		return PhoneSnapMerger.class;
	}
}
