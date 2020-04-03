package br.com.mind5.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemMerger;
import br.com.mind5.message.sysMessage.info.SymsgCopier;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.decisionTree.RootSymsgSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCartemMergeSymsg extends ActionVisitorTemplateMergeV1<CartemInfo, SymsgInfo> {
	
	public VisiCartemMergeSymsg(Connection conn, String schemaName) {
		super(conn, schemaName, SymsgInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SymsgInfo>> getTreeClassHook() {
		return RootSymsgSelect.class;
	}
	
	
	
	@Override protected List<SymsgInfo> toActionClassHook(List<CartemInfo> recordInfos) {
		return SymsgCopier.copyFromCartem(recordInfos);
	}
	
	
	
	@Override protected List<CartemInfo> mergeHook(List<CartemInfo> recordInfos, List<SymsgInfo> selectedInfos) {	
		return CartemMerger.mergeWithSymsg(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
