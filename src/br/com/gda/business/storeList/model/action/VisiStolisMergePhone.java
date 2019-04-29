package br.com.gda.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.phone.info.PhoneCopier;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.info.StolisMerger;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStolisMergePhone extends ActionVisitorTemplateMerge<StolisInfo, PhoneInfo> {
	
	public VisiStolisMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSelect.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<StolisInfo> recordInfos) {
		return PhoneCopier.copyFromStolis(recordInfos);	
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> recordInfos, List<PhoneInfo> selectedInfos) {	
		return StolisMerger.mergeWithPhone(selectedInfos, recordInfos);
	}
}
