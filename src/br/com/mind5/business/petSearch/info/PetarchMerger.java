package br.com.mind5.business.petSearch.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PetarchMerger {
	public static List<PetarchInfo> mergeToSelect(List<PetarchInfo> baseInfos, List<PetarchInfo> selectedInfos) {
		InfoMergerBuilder<PetarchInfo, PetarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetarchMergerVisiToSelect());
		InfoMerger<PetarchInfo, PetarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PetarchInfo> mergeWithCuslis(List<PetarchInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<PetarchInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetarchMergerVisiCuslis());
		InfoMerger<PetarchInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PetarchInfo> mergeWithUsername(List<PetarchInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<PetarchInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PetarchMergerVisiUsername());
		InfoMerger<PetarchInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
