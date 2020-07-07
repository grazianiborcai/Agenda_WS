package br.com.mind5.business.notes.model.action;

import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.info.NotesMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiNotesMergeUsername extends ActionVisitorTemplateMergeV2<NotesInfo, UsernameInfo> {
	
	public VisiNotesMergeUsername(DeciTreeOption<NotesInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<NotesInfo> baseInfos) {
		return UsernameCopier.copyFromNotes(baseInfos);	
	}
	
	
	
	@Override protected List<NotesInfo> mergeHook(List<NotesInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return NotesMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
