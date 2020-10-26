package br.com.mind5.config.sysOwnerConfig.model.action;

import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.info.SysonfigMerger;
import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStoreBusinessContent.model.decisionTree.RootSytorbcSelectDefault;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysonfigMergeSytorbc extends ActionVisitorTemplateMergeV2<SysonfigInfo, SytorbcInfo> {
	
	public VisiSysonfigMergeSytorbc(DeciTreeOption<SysonfigInfo> option) {
		super(option, SytorbcInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SytorbcInfo>> getTreeClassHook() {
		return RootSytorbcSelectDefault.class;
	}
	
	
	
	@Override protected List<SysonfigInfo> mergeHook(List<SysonfigInfo> baseInfos, List<SytorbcInfo> selectedInfos) {	
		return SysonfigMerger.mergeWithSytorbc(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
