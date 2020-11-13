package br.com.mind5.file.fileWrite.model.action;

import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFriteWriteOnDisk extends ActionStdTemplateV2<FriteInfo> {

	public StdFriteWriteOnDisk(DeciTreeOption<FriteInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FriteInfo> buildVisitorHook(DeciTreeOption<FriteInfo> option) {
		return new VisiFriteWriteOnDisk(option);
	}
}
