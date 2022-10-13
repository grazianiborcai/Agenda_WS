package br.com.mind5.business.personLegal.info;


import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PeregMerger {
	public static List<PeregInfo> mergeWithAddress(List<PeregInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<PeregInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeregMergerVisiAddress());
		InfoMerger<PeregInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PeregInfo> mergeWithPerson(List<PeregInfo> baseInfos, List<PersonInfo> selectedInfos) {
		InfoMergerBuilder<PeregInfo, PersonInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeregMergerVisiPerson());
		InfoMerger<PeregInfo, PersonInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PeregInfo> mergeWithPhone(List<PeregInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<PeregInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeregMergerVisiPhone());
		InfoMerger<PeregInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PeregInfo> mergeWithUsername(List<PeregInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<PeregInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeregMergerVisiUsername());
		InfoMerger<PeregInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PeregInfo> mergeToDelete(List<PeregInfo> baseInfos, List<PeregInfo> selectedInfos) {
		InfoMergerBuilder<PeregInfo, PeregInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeregMergerVisiToDelete());
		InfoMerger<PeregInfo, PeregInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PeregInfo> mergeToUpdate(List<PeregInfo> baseInfos, List<PeregInfo> selectedInfos) {
		InfoMergerBuilder<PeregInfo, PeregInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeregMergerVisiToUpdate());
		InfoMerger<PeregInfo, PeregInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PeregInfo> mergeToSelect(List<PeregInfo> baseInfos, List<PeregInfo> selectedInfos) {
		InfoMergerBuilder<PeregInfo, PeregInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PeregMergerVisiToSelect());
		InfoMerger<PeregInfo, PeregInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
