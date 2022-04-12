package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.decisionTree.RefupownRootDelete;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefupownVisiRootSelectFallback extends ActionVisitorTemplateAction<RefupownInfo, RefupownInfo> {

	public RefupownVisiRootSelectFallback(DeciTreeOption<RefupownInfo> option) {
		super(option, RefupownInfo.class, RefupownInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupownInfo>> getTreeClassHook() {
		return RefupownRootDelete.class;
	}
	
	
	
	@Override protected List<RefupownInfo> toBaseClassHook(List<RefupownInfo> baseInfos, List<RefupownInfo> results) {
		return results;
	}
}
