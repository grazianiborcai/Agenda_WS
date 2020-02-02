package br.com.mind5.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneCopier;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.RootPhoneSearch;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStolisMergePhone extends ActionVisitorTemplateMergeV2<StolisInfo, PhoneInfo> {
	
	public VisiStolisMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSearch.class;
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<StolisInfo> baseInfos) {
		return PhoneCopier.copyFromStolis(baseInfos);	
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<PhoneInfo> selectedInfos) {	
		return StolisMerger.mergeWithPhone(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
