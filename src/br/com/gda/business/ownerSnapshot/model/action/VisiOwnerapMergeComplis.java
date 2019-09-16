package br.com.gda.business.ownerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.companyList.info.ComplisCopier;
import br.com.gda.business.companyList.info.ComplisInfo;
import br.com.gda.business.companyList.model.decisionTree.RootComplisSelect;
import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.business.ownerSnapshot.info.OwnerapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerapMergeComplis extends ActionVisitorTemplateMergeV2<OwnerapInfo, ComplisInfo> {
	
	public VisiOwnerapMergeComplis(Connection conn, String schemaName) {
		super(conn, schemaName, ComplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<ComplisInfo>> getTreeClassHook() {
		return RootComplisSelect.class;
	}
	
	
	
	protected List<ComplisInfo> toActionClassHook(List<OwnerapInfo> recordInfos) {
		return ComplisCopier.copyFromOwnerap(recordInfos);	
	}
	
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> recordInfos, List<ComplisInfo> selectedInfos) {	
		return OwnerapMerger.mergeWithComplis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
