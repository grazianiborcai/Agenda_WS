package br.com.mind5.business.materialTextSearch.model.checker;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.model.decisionTree.RootMatextarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextarchCheckExist extends ModelCheckerTemplateActionV2<MatextarchInfo, MatextarchInfo> {	
	
	public MatextarchCheckExist(ModelCheckerOption option) {
		super(option, MatextarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatextarchInfo> buildActionHook(DeciTreeOption<MatextarchInfo> option) {
		ActionStd<MatextarchInfo> select = new RootMatextarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TEXT_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_SEARCH_NOT_FOUND;
	}
}
