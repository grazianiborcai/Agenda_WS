package br.com.mind5.webhook.pagarmeHook.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.model.decisionTree.PagookRootInsert;

public final class PagookModelInsert extends ModelTemplate<PagookInfo> {

	public PagookModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PagookInfo.class);
	}
	
	
	
	@Override protected DeciTree<PagookInfo> getDecisionTreeHook(DeciTreeOption<PagookInfo> option) {
		return new PagookRootInsert(option);
	}
}
