package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.model.decisionTree.OwnerapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerVisiOwnerapInsert extends ActionVisitorTemplateAction<OwnerInfo, OwnerapInfo> {

	public OwnerVisiOwnerapInsert(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, OwnerapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnerapInfo>> getTreeClassHook() {
		return OwnerapRootInsert.class;
	}
	
	
	
	protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<OwnerapInfo> results) {
		return OwnerMerger.mergeWithOwnerap(baseInfos, results);
	}
}
