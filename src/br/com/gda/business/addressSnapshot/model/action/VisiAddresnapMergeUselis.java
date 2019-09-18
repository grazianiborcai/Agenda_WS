package br.com.gda.business.addressSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.info.AddresnapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.userList.info.UselisCopier;
import br.com.gda.security.userList.info.UselisInfo;
import br.com.gda.security.userList.model.decisionTree.RootUselisSelect;

final class VisiAddresnapMergeUselis extends ActionVisitorTemplateMergeV2<AddresnapInfo, UselisInfo> {
	
	public VisiAddresnapMergeUselis(Connection conn, String schemaName) {
		super(conn, schemaName, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return RootUselisSelect.class;
	}

	
	
	protected List<UselisInfo> toActionClassHook(List<AddresnapInfo> recordInfos) {
		return UselisCopier.copyFromAddresnap(recordInfos);	
	}	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> recordInfos, List<UselisInfo> selectedInfos) {	
		return AddresnapMerger.mergeWithUselis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
