package br.com.mind5.business.materialList.model.action;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.decisionTree.MatlisRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatlisVisiRootSelect extends ActionVisitorTemplateAction<MatlisInfo, MatlisInfo> {

	public MatlisVisiRootSelect(DeciTreeOption<MatlisInfo> option) {
		super(option, MatlisInfo.class, MatlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatlisInfo>> getTreeClassHook() {
		return MatlisRootSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> toBaseClassHook(List<MatlisInfo> baseInfos, List<MatlisInfo> results) {
		return results;
	}
}
