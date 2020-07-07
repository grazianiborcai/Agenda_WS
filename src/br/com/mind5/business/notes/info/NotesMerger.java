package br.com.mind5.business.notes.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class NotesMerger {
	public static List<NotesInfo> mergeWithUsername(List<NotesInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<NotesInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new NotesVisiMergeUsername());
		InfoMergerV3<NotesInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<NotesInfo> mergeToSelect(List<NotesInfo> baseInfos, List<NotesInfo> selectedInfos) {
		InfoMergerBuilderV3<NotesInfo, NotesInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new NotesVisiMergeToSelect());
		InfoMergerV3<NotesInfo, NotesInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<NotesInfo> mergeToUpdate(List<NotesInfo> baseInfos, List<NotesInfo> selectedInfos) {
		InfoMergerBuilderV3<NotesInfo, NotesInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new NotesVisiMergeToUpdate());
		InfoMergerV3<NotesInfo, NotesInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
