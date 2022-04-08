package br.com.mind5.business.notes.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class NotesMerger {
	public static List<NotesInfo> mergeWithUsername(List<NotesInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<NotesInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new NotesMergerVisiUsername());
		InfoMerger<NotesInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<NotesInfo> mergeToSelect(List<NotesInfo> baseInfos, List<NotesInfo> selectedInfos) {
		InfoMergerBuilder<NotesInfo, NotesInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new NotesMergerVisiToSelect());
		InfoMerger<NotesInfo, NotesInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<NotesInfo> mergeToUpdate(List<NotesInfo> baseInfos, List<NotesInfo> selectedInfos) {
		InfoMergerBuilder<NotesInfo, NotesInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new NotesMergerVisiToUpdate());
		InfoMerger<NotesInfo, NotesInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
