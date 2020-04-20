package br.com.mind5.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialType.model.decisionTree.RootMatypeSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatsnapMergeMatype extends ActionVisitorTemplateMergeV1<MatsnapInfo, MatypeInfo> {
	
	public VisiMatsnapMergeMatype(Connection conn, String schemaName) {
		super(conn, schemaName, MatypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatypeInfo>> getTreeClassHook() {
		return RootMatypeSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> recordInfos, List<MatypeInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatype(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
