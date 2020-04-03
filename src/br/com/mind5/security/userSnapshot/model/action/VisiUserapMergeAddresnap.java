package br.com.mind5.security.userSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.RootAddresnapSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.info.UserapMerger;

final class VisiUserapMergeAddresnap extends ActionVisitorTemplateMergeV1<UserapInfo, AddresnapInfo> {
	
	public VisiUserapMergeAddresnap(Connection conn, String schemaName) {
		super(conn, schemaName, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return RootAddresnapSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> toActionClassHook(List<UserapInfo> baseInfos) {
		return AddresnapCopier.copyFromUserapKey(baseInfos);
	}	
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {	
		return UserapMerger.mergeWithAddresnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
