package br.com.mind5.file.fileImage.model.action;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgMergeFimarchStore extends ActionStdTemplate<FimgInfo> {

	public StdFimgMergeFimarchStore(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimgInfo> buildVisitorHook(DeciTreeOption<FimgInfo> option) {
		return new VisiFimgMergeFimarchStore(option);
	}
}
