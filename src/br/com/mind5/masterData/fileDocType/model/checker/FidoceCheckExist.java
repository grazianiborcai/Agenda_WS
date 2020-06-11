package br.com.mind5.masterData.fileDocType.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.fileDocType.info.FidoceInfo;
import br.com.mind5.masterData.fileDocType.model.action.StdFidoceDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FidoceCheckExist extends ModelCheckerTemplateActionV2<FidoceInfo, FidoceInfo> {
	
	public FidoceCheckExist(ModelCheckerOption option) {
		super(option, FidoceInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<FidoceInfo> buildActionHook(DeciTreeOption<FidoceInfo> option) {
		ActionStdV1<FidoceInfo> select = new StdFidoceDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FILE_DOC_TYPE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_DOC_TYPE_NOT_FOUND;
	}
}
