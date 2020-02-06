package br.com.mind5.business.orderListAuth;

import br.com.mind5.business.orderListAuth.info.OrdistauInfo;
import br.com.mind5.business.orderListAuth.model.decisionTree.RootOrdistauSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdistauModelSearch extends ModelTemplate<OrdistauInfo> {

	public OrdistauModelSearch(OrdistauInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OrdistauInfo> getDecisionTreeHook(DeciTreeOption<OrdistauInfo> option) {
		return new RootOrdistauSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
