package br.com.mind5.business.notes.model.action;

import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.info.NotesMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiNotesMergeToUpdate extends ActionVisitorTemplateMerge<NotesInfo, NotesInfo> {
	
	public VisiNotesMergeToUpdate(DeciTreeOption<NotesInfo> option) {
		super(option, NotesInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<NotesInfo>> getActionClassHook() {
		return StdNotesDaoSelect.class;
	}
	
	
	
	@Override protected List<NotesInfo> toActionClassHook(List<NotesInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<NotesInfo> mergeHook(List<NotesInfo> baseInfos, List<NotesInfo> selectedInfos) {	
		return NotesMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
