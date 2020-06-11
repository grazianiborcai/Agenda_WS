package br.com.mind5.masterData.fileDocType.model.action;

import br.com.mind5.masterData.fileDocType.info.FidoceInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFidoceDaoSelect extends ActionStdTemplateV2<FidoceInfo> {

	public StdFidoceDaoSelect(DeciTreeOption<FidoceInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FidoceInfo> buildVisitorHook(DeciTreeOption<FidoceInfo> option) {
		return new VisiFidoceDaoSelect(option);
	}
}
