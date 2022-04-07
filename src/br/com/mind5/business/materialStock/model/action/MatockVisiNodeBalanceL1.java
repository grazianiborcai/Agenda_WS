package br.com.mind5.business.materialStock.model.action;

import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.decisionTree.MatockNodeBalanceL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatockVisiNodeBalanceL1 extends ActionVisitorTemplateAction<MatockInfo, MatockInfo> {

	public MatockVisiNodeBalanceL1(DeciTreeOption<MatockInfo> option) {
		super(option, MatockInfo.class, MatockInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatockInfo>> getTreeClassHook() {
		return MatockNodeBalanceL1.class;
	}
	
	
	
	@Override protected List<MatockInfo> toBaseClassHook(List<MatockInfo> baseInfos, List<MatockInfo> results) {
		return results;
	}
}
