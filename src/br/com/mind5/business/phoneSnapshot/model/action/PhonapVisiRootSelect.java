package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.decisionTree.PhonapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonapVisiRootSelect extends ActionVisitorTemplateAction<PhonapInfo, PhonapInfo> {

	public PhonapVisiRootSelect(DeciTreeOption<PhonapInfo> option) {
		super(option, PhonapInfo.class, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return PhonapRootSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> toBaseClassHook(List<PhonapInfo> baseInfos, List<PhonapInfo> results) {
		return results;
	}
}
