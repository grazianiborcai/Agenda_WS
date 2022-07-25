package br.com.mind5.masterData.refundPolicyGroup.model.action;

import java.util.List;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.decisionTree.RefugroupRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefugroupVisiRootSelect extends ActionVisitorTemplateAction<RefugroupInfo, RefugroupInfo> {

	public RefugroupVisiRootSelect(DeciTreeOption<RefugroupInfo> option) {
		super(option, RefugroupInfo.class, RefugroupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugroupInfo>> getTreeClassHook() {
		return RefugroupRootSelect.class;
	}
	
	
	
	@Override protected List<RefugroupInfo> toBaseClassHook(List<RefugroupInfo> baseInfos, List<RefugroupInfo> results) {
		return results;
	}
}
