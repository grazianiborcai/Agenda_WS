package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.decisionTree.BookiceRootSchedine;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiBookiceValidate extends ActionVisitorTemplateAction<SchedineInfo, BookiceInfo> {

	public SchedineVisiBookiceValidate(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, BookiceInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BookiceInfo>> getTreeClassHook() {
		return BookiceRootSchedine.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<BookiceInfo> results) {
		return baseInfos;
	}
}
