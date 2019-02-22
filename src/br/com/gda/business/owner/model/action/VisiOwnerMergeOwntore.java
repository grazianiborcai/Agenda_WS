package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.ownerStore.model.decisionTree.RootOwntoreSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergeOwntore extends ActionVisitorTemplateMerge<OwnerInfo, OwntoreInfo> {
	
	public VisiOwnerMergeOwntore(Connection conn, String schemaName) {
		super(conn, schemaName, OwntoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwntoreInfo>> getTreeClassHook() {
		return RootOwntoreSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<OwnerInfo>> getMergerClassHook() {
		return OwnerMerger.class;
	}
	
	
	
	@Override protected List<OwntoreInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return OwntoreInfo.copyFrom(recordInfos);	
	}
}
