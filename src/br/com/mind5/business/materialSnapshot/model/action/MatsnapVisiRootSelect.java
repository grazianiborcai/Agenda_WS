package br.com.mind5.business.materialSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.model.decisionTree.MatsnapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatsnapVisiRootSelect extends ActionVisitorTemplateAction<MatsnapInfo, MatsnapInfo> {

	public MatsnapVisiRootSelect(DeciTreeOption<MatsnapInfo> option) {
		super(option, MatsnapInfo.class, MatsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatsnapInfo>> getTreeClassHook() {
		return MatsnapRootSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> toBaseClassHook(List<MatsnapInfo> baseInfos, List<MatsnapInfo> results) {
		return results;
	}
}
