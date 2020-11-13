package br.com.mind5.masterData.fileDocType.model.action;

import br.com.mind5.masterData.fileDocType.info.FidoceInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFidoceDaoSelect extends ActionStdTemplate<FidoceInfo> {

	public StdFidoceDaoSelect(DeciTreeOption<FidoceInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FidoceInfo> buildVisitorHook(DeciTreeOption<FidoceInfo> option) {
		return new VisiFidoceDaoSelect(option);
	}
}
