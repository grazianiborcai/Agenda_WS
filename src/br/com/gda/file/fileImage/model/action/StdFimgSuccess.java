package br.com.gda.file.fileImage.model.action;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.model.action.commom.ActionStdSuccessTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFimgSuccess extends ActionStdSuccessTemplate<FimgInfo> {
	public StdFimgSuccess(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
}
