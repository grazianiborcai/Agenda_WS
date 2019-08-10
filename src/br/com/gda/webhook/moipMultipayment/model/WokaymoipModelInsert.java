package br.com.gda.webhook.moipMultipayment.model;

import javax.servlet.http.HttpServletRequest;

import br.com.gda.json.JsonBodyParser;
import br.com.gda.json.webhook.moipMultipayment.JwokaymoipBodyParser;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipInfo;
import br.com.gda.webhook.moipMultipayment.model.decisionTree.RootWokaymoipInsert;

public final class WokaymoipModelInsert extends ModelTemplate<WokaymoipInfo> {

	public WokaymoipModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, WokaymoipInfo.class);
	}
	
	
	
	@Override protected DeciTree<WokaymoipInfo> getDecisionTreeHook(DeciTreeOption<WokaymoipInfo> option) {
		return new RootWokaymoipInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
	
	
	
	@Override protected JsonBodyParser<WokaymoipInfo> getJsonParserHook(Class<WokaymoipInfo> tClazz) {
		return new JwokaymoipBodyParser<WokaymoipInfo>(tClazz);
	}
}
