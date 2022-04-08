package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.MatoreRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreVisiRootSelect extends ActionVisitorTemplateAction<MatoreInfo, MatoreInfo> {

	public MatoreVisiRootSelect(DeciTreeOption<MatoreInfo> option) {
		super(option, MatoreInfo.class, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return MatoreRootSelect.class;
	}
	
	
	
	@Override protected List<MatoreInfo> toBaseClassHook(List<MatoreInfo> baseInfos, List<MatoreInfo> results) {
		return results;
	}
}
