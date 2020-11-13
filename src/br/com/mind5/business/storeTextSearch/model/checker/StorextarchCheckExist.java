package br.com.mind5.business.storeTextSearch.model.checker;

import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.decisionTree.RootStorextarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextarchCheckExist extends ModelCheckerTemplateActionV2<StorextarchInfo, StorextarchInfo> {	
	
	public StorextarchCheckExist(ModelCheckerOption option) {
		super(option, StorextarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<StorextarchInfo> buildActionHook(DeciTreeOption<StorextarchInfo> option) {
		ActionStdV2<StorextarchInfo> select = new RootStorextarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<StorextarchInfo> toActionClassHook(List<StorextarchInfo> recordInfos) {
		return recordInfos;	
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_TEXT_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_TEXT_SEARCH_NOT_FOUND;
	}
}
