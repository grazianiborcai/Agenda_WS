package br.com.mind5.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.RootAddresnapSelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStorapMergeAddresnap extends ActionVisitorTemplateMergeV2<StorapInfo, AddresnapInfo> {
	
	public VisiStorapMergeAddresnap(Connection conn, String schemaName) {
		super(conn, schemaName, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return RootAddresnapSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> toActionClassHook(List<StorapInfo> recordInfos) {
		return AddresnapCopier.copyFromStorap(recordInfos);	
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> recordInfos, List<AddresnapInfo> selectedInfos) {	
		return StorapMerger.mergeWithAddresnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
