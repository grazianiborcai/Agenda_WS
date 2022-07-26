package br.com.mind5.config.sysStoreSignup.model.action;

import java.util.List;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.decisionTree.SysotupRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SysotupVisiRootSelect extends ActionVisitorTemplateAction<SysotupInfo, SysotupInfo> {

	public SysotupVisiRootSelect(DeciTreeOption<SysotupInfo> option) {
		super(option, SysotupInfo.class, SysotupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SysotupInfo>> getTreeClassHook() {
		return SysotupRootSelect.class;
	}
	
	
	
	@Override protected List<SysotupInfo> toBaseClassHook(List<SysotupInfo> baseInfos, List<SysotupInfo> results) {
		return results;
	}
}
