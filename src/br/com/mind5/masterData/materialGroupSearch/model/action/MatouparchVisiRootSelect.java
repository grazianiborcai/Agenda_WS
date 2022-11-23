package br.com.mind5.masterData.materialGroupSearch.model.action;

import java.util.List;

import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.masterData.materialGroupSearch.model.decisionTree.MatouparchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatouparchVisiRootSelect extends ActionVisitorTemplateAction<MatouparchInfo, MatouparchInfo> {

	public MatouparchVisiRootSelect(DeciTreeOption<MatouparchInfo> option) {
		super(option, MatouparchInfo.class, MatouparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatouparchInfo>> getTreeClassHook() {
		return MatouparchRootSelect.class;
	}
	
	
	
	@Override protected List<MatouparchInfo> toBaseClassHook(List<MatouparchInfo> baseInfos, List<MatouparchInfo> results) {
		return results;
	}
}
