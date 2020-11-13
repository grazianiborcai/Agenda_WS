package br.com.mind5.masterData.fileDocType.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.fileDocType.info.FidoceInfo;
import br.com.mind5.masterData.fileDocType.model.action.StdFidoceDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FidoceCheckExist extends ModelCheckerTemplateAction<FidoceInfo, FidoceInfo> {
	
	public FidoceCheckExist(ModelCheckerOption option) {
		super(option, FidoceInfo.class);
	}
	
	
	
	@Override protected ActionStd<FidoceInfo> buildActionHook(DeciTreeOption<FidoceInfo> option) {
		ActionStd<FidoceInfo> select = new StdFidoceDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FILE_DOC_TYPE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_DOC_TYPE_NOT_FOUND;
	}
}
