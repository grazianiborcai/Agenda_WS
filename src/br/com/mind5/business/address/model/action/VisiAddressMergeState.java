package br.com.mind5.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootStateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiAddressMergeState extends ActionVisitorTemplateMergeV2<AddressInfo, StateInfo> {
	
	public VisiAddressMergeState(Connection conn, String schemaName) {
		super(conn, schemaName, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return RootStateSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> recordInfos, List<StateInfo> selectedInfos) {
		return AddressMerger.mergeWithState(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
