package br.com.gda.business.phoneSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapMerger;
import br.com.gda.business.storeList.info.StolisCopier;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPhonapMergeStolis extends ActionVisitorTemplateMergeV2<PhonapInfo, StolisInfo> {
	
	public VisiPhonapMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}

	
	
	protected List<StolisInfo> toActionClassHook(List<PhonapInfo> recordInfos) {
		return StolisCopier.copyFromPhonap(recordInfos);	
	}	
	
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> recordInfos, List<StolisInfo> selectedInfos) {	
		return PhonapMerger.mergeWithStolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
