package br.com.mind5.business.orderListAuth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderListAuth.info.OrdistauInfo;
import br.com.mind5.business.orderListAuth.info.OrdistauMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiOrdistauMergeUsername extends ActionVisitorTemplateMergeV2<OrdistauInfo, UsernameInfo> {
	
	public VisiOrdistauMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<OrdistauInfo> mergeHook(List<OrdistauInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return OrdistauMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<OrdistauInfo> baseInfos) {
		return UsernameCopier.copyFromOrdistau(baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
