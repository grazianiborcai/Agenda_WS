package br.com.mind5.business.notes.model.action;

import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.info.NotesMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class NotesVisiMergeToUpdate extends ActionVisitorTemplateMerge<NotesInfo, NotesInfo> {
	
	public NotesVisiMergeToUpdate(DeciTreeOption<NotesInfo> option) {
		super(option, NotesInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<NotesInfo>> getVisitorClassHook() {
		return NotesVisiDaoSelect.class;
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
