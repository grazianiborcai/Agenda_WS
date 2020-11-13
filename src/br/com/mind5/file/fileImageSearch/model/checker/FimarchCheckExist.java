package br.com.mind5.file.fileImageSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.decisionTree.RootFimarchSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimarchCheckExist extends ModelCheckerTemplateActionV2<FimarchInfo, FimarchInfo> {	
	
	public FimarchCheckExist(ModelCheckerOption option) {
		super(option, FimarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<FimarchInfo> buildActionHook(DeciTreeOption<FimarchInfo> option) {
		ActionStdV2<FimarchInfo> select = new RootFimarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FILE_IMG_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_SEARCH_NOT_FOUND;
	}
}
