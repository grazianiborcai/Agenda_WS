package br.com.mind5.business.cartReserveConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.info.CartercoMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiCartercoMergeUsername extends ActionVisitorTemplateMergeV2<CartercoInfo, UsernameInfo> {
	
	public VisiCartercoMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<CartercoInfo> mergeHook(List<CartercoInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return CartercoMerger.mergeWithUsername(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<CartercoInfo> recordInfos) {
		return UsernameCopier.copyFromCarterco(recordInfos);	
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
