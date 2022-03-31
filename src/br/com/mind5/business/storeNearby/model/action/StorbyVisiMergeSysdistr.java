package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyMerger;
import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.config.sysDistrictSearch.model.decisionTree.RootSysdistrSelectFallback;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiMergeSysdistr extends ActionVisitorTemplateMerge<StorbyInfo, SysdistrInfo> {
	
	public StorbyVisiMergeSysdistr(DeciTreeOption<StorbyInfo> option) {
		super(option, SysdistrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysdistrInfo>> getTreeClassHook() {
		return RootSysdistrSelectFallback.class;
	}
	
	
	
	@Override protected List<StorbyInfo> mergeHook(List<StorbyInfo> baseInfos, List<SysdistrInfo> selectedInfos) {	
		return StorbyMerger.mergeWithSysdistr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
