package br.com.mind5.business.personBioSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.business.personBioSnapshot.model.decisionTree.PerbionapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbionapVisiRootSelect extends ActionVisitorTemplateAction<PerbionapInfo, PerbionapInfo> {

	public PerbionapVisiRootSelect(DeciTreeOption<PerbionapInfo> option) {
		super(option, PerbionapInfo.class, PerbionapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbionapInfo>> getTreeClassHook() {
		return PerbionapRootSelect.class;
	}
	
	
	
	@Override protected List<PerbionapInfo> toBaseClassHook(List<PerbionapInfo> baseInfos, List<PerbionapInfo> results) {
		return results;
	}
}
