package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgMergeToSelect extends ActionStdTemplateV2<FimgInfo> {

	public StdFimgMergeToSelect(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FimgInfo> buildVisitorHook(DeciTreeOption<FimgInfo> option) {
		return new VisiFimgMergeToSelect(option);
	}
}
