package br.com.mind5.config.sysDistrictSearch.model.action;

import java.util.List;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.config.sysDistrictSearch.model.decisionTree.SysdistrNodeSelectFallback;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysdistrVisiNodeSelectFallback extends ActionVisitorTemplateAction<SysdistrInfo, SysdistrInfo> {

	public SysdistrVisiNodeSelectFallback(DeciTreeOption<SysdistrInfo> option) {
		super(option, SysdistrInfo.class, SysdistrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysdistrInfo>> getTreeClassHook() {
		return SysdistrNodeSelectFallback.class;
	}
	
	
	
	@Override protected List<SysdistrInfo> toBaseClassHook(List<SysdistrInfo> baseInfos, List<SysdistrInfo> results) {
		return results;
	}
}
