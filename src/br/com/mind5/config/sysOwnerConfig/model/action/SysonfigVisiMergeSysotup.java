package br.com.mind5.config.sysOwnerConfig.model.action;

import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.info.SysonfigMerger;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.decisionTree.SysotupRootSelectDefault;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysonfigVisiMergeSysotup extends ActionVisitorTemplateMerge<SysonfigInfo, SysotupInfo> {
	
	public SysonfigVisiMergeSysotup(DeciTreeOption<SysonfigInfo> option) {
		super(option, SysotupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysotupInfo>> getTreeClassHook() {
		return SysotupRootSelectDefault.class;
	}
	
	
	
	@Override protected List<SysonfigInfo> mergeHook(List<SysonfigInfo> baseInfos, List<SysotupInfo> selectedInfos) {	
		return SysonfigMerger.mergeWithSysotup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
