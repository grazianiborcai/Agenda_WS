package br.com.mind5.business.notes.model.action;

import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.info.NotesMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiNotesMergeToSelect extends ActionVisitorTemplateMergeV2<NotesInfo, NotesInfo> {
	
	public VisiNotesMergeToSelect(DeciTreeOption<NotesInfo> option) {
		super(option, NotesInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<NotesInfo>> getActionClassHook() {
		return StdNotesDaoSelect.class;
	}
	
	
	
	@Override protected List<NotesInfo> toActionClassHook(List<NotesInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<NotesInfo> mergeHook(List<NotesInfo> baseInfos, List<NotesInfo> selectedInfos) {	
		return NotesMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
