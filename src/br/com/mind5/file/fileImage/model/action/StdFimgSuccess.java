package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgSuccess extends ActionStdSuccessTemplate<FimgInfo> {
	public StdFimgSuccess(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
}
