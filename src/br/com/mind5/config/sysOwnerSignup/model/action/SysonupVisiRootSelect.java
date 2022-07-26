package br.com.mind5.config.sysOwnerSignup.model.action;

import java.util.List;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.model.decisionTree.SysonupRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysonupVisiRootSelect extends ActionVisitorTemplateAction<SysonupInfo, SysonupInfo> {

	public SysonupVisiRootSelect(DeciTreeOption<SysonupInfo> option) {
		super(option, SysonupInfo.class, SysonupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysonupInfo>> getTreeClassHook() {
		return SysonupRootSelect.class;
	}
	
	
	
	@Override protected List<SysonupInfo> toBaseClassHook(List<SysonupInfo> baseInfos, List<SysonupInfo> results) {
		return results;
	}
}
