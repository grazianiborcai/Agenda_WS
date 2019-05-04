package br.com.gda.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.info.AddressMerger;
import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.business.masterData.model.decisionTree.RootStateSelect;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiAddressMergeState extends ActionVisitorTemplateMerge_<AddressInfo, StateInfo> {
	
	public VisiAddressMergeState(Connection conn, String schemaName) {
		super(conn, schemaName, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return RootStateSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> recordInfos, List<StateInfo> selectedInfos) {
		return AddressMerger.mergeWithState(selectedInfos, recordInfos);
	}
}
