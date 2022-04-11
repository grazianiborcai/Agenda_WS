package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.decisionTree.OwnerNodePhoneUpsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerVisiNodePhoneUpsert extends ActionVisitorTemplateAction<OwnerInfo, OwnerInfo> {

	public OwnerVisiNodePhoneUpsert(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, OwnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnerInfo>> getTreeClassHook() {
		return OwnerNodePhoneUpsert.class;
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<OwnerInfo> results) {
		return results;
	}
}
