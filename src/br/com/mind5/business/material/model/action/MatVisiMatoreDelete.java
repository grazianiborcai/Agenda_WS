package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.MatoreRootDeleteFromMat;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiMatoreDelete extends ActionVisitorTemplateAction<MatInfo, MatoreInfo> {
	
	public MatVisiMatoreDelete(DeciTreeOption<MatInfo> option) {
		super(option, MatInfo.class, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return MatoreRootDeleteFromMat.class;
	}
}
