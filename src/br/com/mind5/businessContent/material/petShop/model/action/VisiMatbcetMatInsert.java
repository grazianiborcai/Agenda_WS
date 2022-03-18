package br.com.mind5.businessContent.material.petShop.model.action;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.MatRootInsert;
import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatbcetMatInsert extends ActionVisitorTemplateAction<MatbcetInfo, MatInfo> {

	public VisiMatbcetMatInsert(DeciTreeOption<MatbcetInfo> option) {
		super(option, MatbcetInfo.class, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return MatRootInsert.class;
	}
	
	
	
	protected List<MatbcetInfo> toBaseClassHook(List<MatbcetInfo> baseInfos, List<MatInfo> results) {
		return baseInfos;
	}
}
