package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.model.decisionTree.SysonfigRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerVisiSysonfigInsert extends ActionVisitorTemplateAction<OwnerInfo, SysonfigInfo> {
	
	public OwnerVisiSysonfigInsert(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, SysonfigInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysonfigInfo>> getTreeClassHook() {
		return SysonfigRootInsert.class;
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<SysonfigInfo> results) {
		return baseInfos;
	}
}
