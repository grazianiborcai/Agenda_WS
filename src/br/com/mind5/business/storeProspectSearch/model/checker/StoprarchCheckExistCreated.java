package br.com.mind5.business.storeProspectSearch.model.checker;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.business.storeProspectSearch.model.decisionTree.StoprarchRootSelectCreated;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprarchCheckExistCreated extends ModelCheckerTemplateAction<StoprarchInfo, StoprarchInfo> {
	
	public StoprarchCheckExistCreated(ModelCheckerOption option) {
		super(option, StoprarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<StoprarchInfo> buildActionHook(DeciTreeOption<StoprarchInfo> option) {
		ActionStd<StoprarchInfo> select = new StoprarchRootSelectCreated(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_PROSPECT_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_PROSPECT_SEARCH_NOT_FOUND;
	}
}
