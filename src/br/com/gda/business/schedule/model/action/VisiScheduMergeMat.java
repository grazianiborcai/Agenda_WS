package br.com.gda.business.schedule.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.material.info.MatCopier;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.info.ScheduMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiScheduMergeMat extends ActionVisitorTemplateMergeV2<ScheduInfo, MatInfo> {
	
	public VisiScheduMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> toActionClassHook(List<ScheduInfo> recordInfos) {
		return MatCopier.copyFromSchedu(recordInfos);	
	}
	
	
	
	@Override protected List<ScheduInfo> mergeHook(List<ScheduInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return ScheduMerger.mergeWithMat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
