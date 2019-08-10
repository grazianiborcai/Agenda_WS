package br.com.gda.webhook.moipRefund.model;

import javax.servlet.http.HttpServletRequest;

import br.com.gda.json.JsonBodyParser;
import br.com.gda.json.webhook.moipRefund.JwokefumoipBodyParser;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;
import br.com.gda.webhook.moipRefund.model.decisionTree.RootWokefumoipInsert;

public final class WokefumoipModelInsert extends ModelTemplate<WokefumoipInfo> {

	public WokefumoipModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, WokefumoipInfo.class);
	}
	
	
	
	@Override protected DeciTree<WokefumoipInfo> getDecisionTreeHook(DeciTreeOption<WokefumoipInfo> option) {
		return new RootWokefumoipInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
	
	
	
	@Override protected JsonBodyParser<WokefumoipInfo> getJsonParserHook(Class<WokefumoipInfo> tClazz) {
		return new JwokefumoipBodyParser<WokefumoipInfo>(tClazz);
	}
}
