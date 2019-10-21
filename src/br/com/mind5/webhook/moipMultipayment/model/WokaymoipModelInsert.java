package br.com.mind5.webhook.moipMultipayment.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.json.JsonBodyParser;
import br.com.mind5.json.webhook.moipMultipayment.JwokaymoipBodyParser;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;
import br.com.mind5.webhook.moipMultipayment.model.decisionTree.RootWokaymoipInsert;

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
