package br.com.mind5.business.petSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.business.petSnapshot.model.decisionTree.PetsnapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetsnapVisiRootSelect extends ActionVisitorTemplateAction<PetsnapInfo, PetsnapInfo> {

	public PetsnapVisiRootSelect(DeciTreeOption<PetsnapInfo> option) {
		super(option, PetsnapInfo.class, PetsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetsnapInfo>> getTreeClassHook() {
		return PetsnapRootSelect.class;
	}
	
	
	
	@Override protected List<PetsnapInfo> toBaseClassHook(List<PetsnapInfo> baseInfos, List<PetsnapInfo> results) {
		return results;
	}
}
