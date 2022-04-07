package br.com.mind5.business.materialPrice.model.action;

import java.util.List;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.business.materialPrice.model.decisionTree.MaticeRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MaticeVisiRootSelect extends ActionVisitorTemplateAction<MaticeInfo, MaticeInfo> {

	public MaticeVisiRootSelect(DeciTreeOption<MaticeInfo> option) {
		super(option, MaticeInfo.class, MaticeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MaticeInfo>> getTreeClassHook() {
		return MaticeRootSelect.class;
	}
	
	
	
	@Override protected List<MaticeInfo> toBaseClassHook(List<MaticeInfo> baseInfos, List<MaticeInfo> results) {
		return results;
	}
}
