package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.decisionTree.RefuporeNodeUpsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeVisiNodeUpsert extends ActionVisitorTemplateAction<RefuporeInfo, RefuporeInfo> {

	public RefuporeVisiNodeUpsert(DeciTreeOption<RefuporeInfo> option) {
		super(option, RefuporeInfo.class, RefuporeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefuporeInfo>> getTreeClassHook() {
		return RefuporeNodeUpsert.class;
	}
	
	
	
	@Override protected List<RefuporeInfo> toBaseClassHook(List<RefuporeInfo> baseInfos, List<RefuporeInfo> results) {
		return results;
	}
}
