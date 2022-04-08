package br.com.mind5.business.notes.model.action;

import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.decisionTree.NotesRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class NotesVisiRootSelect extends ActionVisitorTemplateAction<NotesInfo, NotesInfo> {

	public NotesVisiRootSelect(DeciTreeOption<NotesInfo> option) {
		super(option, NotesInfo.class, NotesInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<NotesInfo>> getTreeClassHook() {
		return NotesRootSelect.class;
	}
	
	
	
	@Override protected List<NotesInfo> toBaseClassHook(List<NotesInfo> baseInfos, List<NotesInfo> results) {
		return results;
	}
}
