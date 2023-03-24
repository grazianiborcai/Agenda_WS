package br.com.mind5.business.phoneDefault.model.action;

import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.model.decisionTree.PhonaultRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonaultVisiRootSelect extends ActionVisitorTemplateAction<PhonaultInfo, PhonaultInfo> {

	public PhonaultVisiRootSelect(DeciTreeOption<PhonaultInfo> option) {
		super(option, PhonaultInfo.class, PhonaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonaultInfo>> getTreeClassHook() {
		return PhonaultRootSelect.class;
	}
	
	
	
	@Override protected List<PhonaultInfo> toBaseClassHook(List<PhonaultInfo> baseInfos, List<PhonaultInfo> results) {
		return results;
	}
}
