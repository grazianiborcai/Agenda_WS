package br.com.mind5.businessContent.material.main.model.action;

import java.util.List;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.businessContent.material.petShop.model.decisionTree.RootMatbcetInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatbcinMatbcetInsert extends ActionVisitorTemplateAction<MatbcinInfo, MatbcetInfo> {

	public VisiMatbcinMatbcetInsert(DeciTreeOption<MatbcinInfo> option) {
		super(option, MatbcinInfo.class, MatbcetInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatbcetInfo>> getTreeClassHook() {
		return RootMatbcetInsert.class;
	}
	
	
	
	protected List<MatbcinInfo> toBaseClassHook(List<MatbcinInfo> baseInfos, List<MatbcetInfo> results) {
		return baseInfos;
	}
}
