package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.config.sysOwnerConfig.model.decisionTree.RootSysonfigInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerSysonfigInsert extends ActionVisitorTemplateAction<OwnerInfo, SysonfigInfo> {
	
	public VisiOwnerSysonfigInsert(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, SysonfigInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysonfigInfo>> getTreeClassHook() {
		return RootSysonfigInsert.class;
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<SysonfigInfo> results) {
		return baseInfos;
	}
}
