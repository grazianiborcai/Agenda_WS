package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialText.info.MatextCopier;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.decisionTree.RootMatextDeleteByMat;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatMatextDelete extends ActionVisitorTemplateActionV2<MatInfo, MatextInfo> {
	
	public VisiMatMatextDelete(DeciTreeOption<MatInfo> option) {
		super(option, MatInfo.class, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextInfo>> getTreeClassHook() {
		return RootMatextDeleteByMat.class;
	}
	
	
	
	@Override protected List<MatextInfo> toActionClassHook(List<MatInfo> baseInfos) {
		return MatextCopier.copyFromMatKey(baseInfos);
	}
}
