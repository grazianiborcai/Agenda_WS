package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.phone.info.PhoneCopier;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergePhone extends ActionVisitorTemplateMerge_<OwnerInfo, PhoneInfo> {
	
	public VisiOwnerMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<OwnerInfo>> getMergerClassHook() {
		return OwnerMerger.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return PhoneCopier.copyFromOwner(recordInfos);	
	}
}
