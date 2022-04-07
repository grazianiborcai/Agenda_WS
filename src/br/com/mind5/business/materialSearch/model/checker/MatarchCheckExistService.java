package br.com.mind5.business.materialSearch.model.checker;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.decisionTree.MatarchRootSelectService;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatarchCheckExistService extends ModelCheckerTemplateAction<MatarchInfo, MatarchInfo> {	
	
	public MatarchCheckExistService(ModelCheckerOption option) {
		super(option, MatarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatarchInfo> buildActionHook(DeciTreeOption<MatarchInfo> option) {
		ActionStd<MatarchInfo> selectService = new MatarchRootSelectService(option).toAction();		
		return selectService;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_SEARCH_SERVICE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_SEARCH_SERVICE_NOT_FOUND;
	}
}
