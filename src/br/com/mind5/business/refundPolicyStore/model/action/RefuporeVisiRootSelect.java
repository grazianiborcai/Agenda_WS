package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.decisionTree.RefuporeRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeVisiRootSelect extends ActionVisitorTemplateAction<RefuporeInfo, RefuporeInfo> {

	public RefuporeVisiRootSelect(DeciTreeOption<RefuporeInfo> option) {
		super(option, RefuporeInfo.class, RefuporeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefuporeInfo>> getTreeClassHook() {
		return RefuporeRootSelect.class;
	}
	
	
	
	@Override protected List<RefuporeInfo> toBaseClassHook(List<RefuporeInfo> baseInfos, List<RefuporeInfo> results) {
		return results;
	}
}
