package br.com.mind5.config.sysOwnerConfig.model.action;

import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.info.SysonfigMerger;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.decisionTree.RootSytotinSelectDefault;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysonfigMergeSytotin extends ActionVisitorTemplateMerge<SysonfigInfo, SytotinInfo> {
	
	public VisiSysonfigMergeSytotin(DeciTreeOption<SysonfigInfo> option) {
		super(option, SytotinInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytotinInfo>> getTreeClassHook() {
		return RootSytotinSelectDefault.class;
	}
	
	
	
	@Override protected List<SysonfigInfo> mergeHook(List<SysonfigInfo> baseInfos, List<SytotinInfo> selectedInfos) {	
		return SysonfigMerger.mergeWithSytotin(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
