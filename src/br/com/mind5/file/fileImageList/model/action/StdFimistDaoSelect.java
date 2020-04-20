package br.com.mind5.file.fileImageList.model.action;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimistDaoSelect extends ActionStdTemplateV2<FimistInfo> {

	public StdFimistDaoSelect(DeciTreeOption<FimistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FimistInfo> buildVisitorHook(DeciTreeOption<FimistInfo> option) {
		return new VisiFimistDaoSelect(option);
	}
}
