package br.com.mind5.webhook.pagarmeHook.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.model.decisionTree.PagookNodeInsertL1;

public final class PagookVisiNodeInsertL1 extends ActionVisitorTemplateAction<PagookInfo, PagookInfo> {

	public PagookVisiNodeInsertL1(DeciTreeOption<PagookInfo> option) {
		super(option, PagookInfo.class, PagookInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PagookInfo>> getTreeClassHook() {
		return PagookNodeInsertL1.class;
	}
	
	
	
	@Override protected List<PagookInfo> toBaseClassHook(List<PagookInfo> baseInfos, List<PagookInfo> results) {
		return results;
	}
}
