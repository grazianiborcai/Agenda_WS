package br.com.mind5.config.sysOwnerConfig.model.action;

import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.info.SysonfigMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSysonfigMergeToSelect extends ActionVisitorTemplateMerge<SysonfigInfo, SysonfigInfo> {
	
	public VisiSysonfigMergeToSelect(DeciTreeOption<SysonfigInfo> option) {
		super(option, SysonfigInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SysonfigInfo>> getActionClassHook() {
		return StdSysonfigDaoSelect.class;
	}
	
	
	
	@Override protected List<SysonfigInfo> toActionClassHook(List<SysonfigInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<SysonfigInfo> mergeHook(List<SysonfigInfo> baseInfos, List<SysonfigInfo> selectedInfos) {	
		return SysonfigMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
