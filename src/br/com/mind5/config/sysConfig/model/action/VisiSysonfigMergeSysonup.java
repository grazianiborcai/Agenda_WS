package br.com.mind5.config.sysConfig.model.action;

import java.util.List;

import br.com.mind5.config.sysConfig.info.SysonfigInfo;
import br.com.mind5.config.sysConfig.info.SysonfigMerger;
import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.model.decisionTree.RootSysonupSelectDefault;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysonfigMergeSysonup extends ActionVisitorTemplateMergeV2<SysonfigInfo, SysonupInfo> {
	
	public VisiSysonfigMergeSysonup(DeciTreeOption<SysonfigInfo> option) {
		super(option, SysonupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysonupInfo>> getTreeClassHook() {
		return RootSysonupSelectDefault.class;
	}
	
	
	
	@Override protected List<SysonfigInfo> mergeHook(List<SysonfigInfo> baseInfos, List<SysonupInfo> selectedInfos) {	
		return SysonfigMerger.mergeWithSysonup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
