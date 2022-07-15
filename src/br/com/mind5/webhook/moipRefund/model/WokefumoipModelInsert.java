package br.com.mind5.webhook.moipRefund.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.json.JsonBodyParser;
import br.com.mind5.json.webhook.moipRefund.JwokefumoipBodyParser;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;
import br.com.mind5.webhook.moipRefund.model.decisionTree.WokefumoipRootInsert;

public final class WokefumoipModelInsert extends ModelTemplate<WokefumoipInfo> {

	public WokefumoipModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, WokefumoipInfo.class);
	}
	
	
	
	@Override protected DeciTree<WokefumoipInfo> getDecisionTreeHook(DeciTreeOption<WokefumoipInfo> option) {
		return new WokefumoipRootInsert(option);
	}
	
	
	
	@Override protected JsonBodyParser<WokefumoipInfo> getJsonParserHook(Class<WokefumoipInfo> tClazz) {
		return new JwokefumoipBodyParser<WokefumoipInfo>(tClazz);
	}
}
