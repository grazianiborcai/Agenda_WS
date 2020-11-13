package br.com.mind5.business.materialTextSearch.model.checker;

import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.model.decisionTree.RootMatextarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextarchCheckExist extends ModelCheckerTemplateActionV2<MatextarchInfo, MatextarchInfo> {	
	
	public MatextarchCheckExist(ModelCheckerOption option) {
		super(option, MatextarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<MatextarchInfo> buildActionHook(DeciTreeOption<MatextarchInfo> option) {
		ActionStdV2<MatextarchInfo> select = new RootMatextarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<MatextarchInfo> toActionClassHook(List<MatextarchInfo> recordInfos) {
		return recordInfos;	
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_TEXT_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_SEARCH_NOT_FOUND;
	}
}
