package br.com.mind5.config.sysOwnerConfig.model.action;

import java.util.List;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.config.sysDistrictSearch.model.decisionTree.SysdistrRootSelectDefault;
import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.info.SysonfigMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysonfigVisiMergeSysdistr extends ActionVisitorTemplateMerge<SysonfigInfo, SysdistrInfo> {
	
	public SysonfigVisiMergeSysdistr(DeciTreeOption<SysonfigInfo> option) {
		super(option, SysdistrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysdistrInfo>> getTreeClassHook() {
		return SysdistrRootSelectDefault.class;
	}
	
	
	
	@Override protected List<SysonfigInfo> mergeHook(List<SysonfigInfo> baseInfos, List<SysdistrInfo> selectedInfos) {	
		return SysonfigMerger.mergeWithSysdistr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
