package br.com.mind5.file.filePath.model.action;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFathDaoSelect extends ActionStdTemplateV2<FathInfo> {

	public StdFathDaoSelect(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FathInfo> buildVisitorHook(DeciTreeOption<FathInfo> option) {
		return new VisiFathDaoSelect(option);
	}
}
