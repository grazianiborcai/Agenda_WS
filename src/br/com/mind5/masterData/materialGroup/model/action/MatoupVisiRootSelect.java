package br.com.mind5.masterData.materialGroup.model.action;

import java.util.List;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.decisionTree.MatoupRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoupVisiRootSelect extends ActionVisitorTemplateAction<MatoupInfo, MatoupInfo> {

	public MatoupVisiRootSelect(DeciTreeOption<MatoupInfo> option) {
		super(option, MatoupInfo.class, MatoupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoupInfo>> getTreeClassHook() {
		return MatoupRootSelect.class;
	}
	
	
	
	@Override protected List<MatoupInfo> toBaseClassHook(List<MatoupInfo> baseInfos, List<MatoupInfo> results) {
		return results;
	}
}
