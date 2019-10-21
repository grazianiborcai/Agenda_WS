package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatCopier;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.RootMatSelect;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiSchedinapMergeMat extends ActionVisitorTemplateMergeV2<SchedinapInfo, MatInfo> {
	
	public VisiSchedinapMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> toActionClassHook(List<SchedinapInfo> recordInfos) {
		return MatCopier.copyFromSchedinap(recordInfos);	
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return SchedinapMerger.mergeWithMat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
