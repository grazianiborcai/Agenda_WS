package br.com.mind5.stats.statsUserAccount.userAccount.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;
import br.com.mind5.stats.statsUserAccount.userAccount.model.decisionTree.RootSuseracSelectLtm;

public final class SuseracModelSelectLtm extends ModelTemplate<SuseracInfo> {

	public SuseracModelSelectLtm(SuseracInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SuseracInfo> getDecisionTreeHook(DeciTreeOption<SuseracInfo> option) {
		return new RootSuseracSelectLtm(option);
	}
}
