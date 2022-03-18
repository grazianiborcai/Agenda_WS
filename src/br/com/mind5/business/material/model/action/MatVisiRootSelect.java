package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.MatRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiRootSelect extends ActionVisitorTemplateAction<MatInfo, MatInfo> {

	public MatVisiRootSelect(DeciTreeOption<MatInfo> option) {
		super(option, MatInfo.class, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return MatRootSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> toBaseClassHook(List<MatInfo> baseInfos, List<MatInfo> results) {
		return results;
	}
}
