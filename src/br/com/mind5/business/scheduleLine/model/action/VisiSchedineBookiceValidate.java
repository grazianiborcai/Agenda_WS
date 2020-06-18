package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.decisionTree.RootBookiceSchedine;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineBookiceValidate extends ActionVisitorTemplateActionV2<SchedineInfo, BookiceInfo> {

	public VisiSchedineBookiceValidate(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, BookiceInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BookiceInfo>> getTreeClassHook() {
		return RootBookiceSchedine.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<BookiceInfo> results) {
		return baseInfos;
	}
}
