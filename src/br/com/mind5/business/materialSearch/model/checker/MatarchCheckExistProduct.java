package br.com.mind5.business.materialSearch.model.checker;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.decisionTree.RootMatarchSelectProduct;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatarchCheckExistProduct extends ModelCheckerTemplateActionV2<MatarchInfo, MatarchInfo> {	
	
	public MatarchCheckExistProduct(ModelCheckerOption option) {
		super(option, MatarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<MatarchInfo> buildActionHook(DeciTreeOption<MatarchInfo> option) {
		ActionStdV2<MatarchInfo> selectService = new RootMatarchSelectProduct(option).toAction();		
		return selectService;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_SEARCH_PRODUCT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_SEARCH_PRODUCT_NOT_FOUND;
	}
}
