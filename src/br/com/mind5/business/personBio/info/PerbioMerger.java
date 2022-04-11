package br.com.mind5.business.personBio.info;

import java.util.List;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PerbioMerger {
	public static List<PerbioInfo> mergeWithUsername(List<PerbioInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbioMergerVisiUsername());
		InfoMerger<PerbioInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PerbioInfo> mergeWithPerbiorch(List<PerbioInfo> baseInfos, List<PerbiorchInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, PerbiorchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbioMergerVisiPerbiorch());
		InfoMerger<PerbioInfo, PerbiorchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PerbioInfo> mergeWithPerbionap(List<PerbioInfo> baseInfos, List<PerbionapInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, PerbionapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbioMergerVisiPerbionap());
		InfoMerger<PerbioInfo, PerbionapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PerbioInfo> mergeToSelect(List<PerbioInfo> baseInfos, List<PerbioInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, PerbioInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbioMergerVisiToSelect());
		InfoMerger<PerbioInfo, PerbioInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PerbioInfo> mergeToUpdate(List<PerbioInfo> baseInfos, List<PerbioInfo> selectedInfos) {
		InfoMergerBuilder<PerbioInfo, PerbioInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PerbioMergerVisiToUpdate());
		InfoMerger<PerbioInfo, PerbioInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
