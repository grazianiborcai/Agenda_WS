package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerMerger;
import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.model.decisionTree.RootOwnerapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerInsertOwnerap extends ActionVisitorTemplateActionV2<OwnerInfo, OwnerapInfo> {

	public VisiOwnerInsertOwnerap(DeciTreeOption<OwnerInfo> option) {
		super(option, OwnerInfo.class, OwnerapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnerapInfo>> getTreeClassHook() {
		return RootOwnerapInsert.class;
	}
	
	
	
	protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<OwnerapInfo> results) {
		return OwnerMerger.mergeWithOwnerap(baseInfos, results);
	}
}
