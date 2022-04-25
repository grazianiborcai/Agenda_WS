package br.com.mind5.business.employeeLunchTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapInfo;
import br.com.mind5.business.employeeLunchTimeSnapshot.model.decisionTree.EmplutmapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmapVisiRootSelect extends ActionVisitorTemplateAction<EmplutmapInfo, EmplutmapInfo> {

	public EmplutmapVisiRootSelect(DeciTreeOption<EmplutmapInfo> option) {
		super(option, EmplutmapInfo.class, EmplutmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplutmapInfo>> getTreeClassHook() {
		return EmplutmapRootSelect.class;
	}
	
	
	
	@Override protected List<EmplutmapInfo> toBaseClassHook(List<EmplutmapInfo> baseInfos, List<EmplutmapInfo> results) {
		return results;
	}
}
