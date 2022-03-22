package br.com.mind5.business.customerList.model.action;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.CuslisRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CuslisVisiRootSelect extends ActionVisitorTemplateAction<CuslisInfo, CuslisInfo> {

	public CuslisVisiRootSelect(DeciTreeOption<CuslisInfo> option) {
		super(option, CuslisInfo.class, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return CuslisRootSelect.class;
	}
	
	
	
	@Override protected List<CuslisInfo> toBaseClassHook(List<CuslisInfo> baseInfos, List<CuslisInfo> results) {
		return results;
	}
}
