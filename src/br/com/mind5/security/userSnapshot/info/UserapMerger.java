package br.com.mind5.security.userSnapshot.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class UserapMerger {	
	public static List<UserapInfo> mergeWithPersolis(List<UserapInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilderV3<UserapInfo, PersolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserapVisiMergePersolis());
		InfoMergerV3<UserapInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	

	public static List<UserapInfo> mergeWithAddresnap(List<UserapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
	InfoMergerBuilderV3<UserapInfo, AddresnapInfo> builder = new InfoMergerBuilderV3<>();
	
	builder.addBaseInfos(baseInfos);
	builder.addSelectedInfos(selectedInfos);
	builder.addVisitor(new UserapVisiMergeAddresnap());
	InfoMergerV3<UserapInfo, AddresnapInfo> merger = builder.build();		

	return merger.merge();
}	
	
	
	
	public static List<UserapInfo> mergeWithPersonap(List<UserapInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		InfoMergerBuilderV3<UserapInfo, PersonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserapVisiMergePersonap());
		InfoMergerV3<UserapInfo, PersonapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<UserapInfo> mergeWithPhonap(List<UserapInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilderV3<UserapInfo, PhonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserapVisiMergePhonap());
		InfoMergerV3<UserapInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<UserapInfo> mergeToSelect(List<UserapInfo> baseInfos, List<UserapInfo> selectedInfos) {
		InfoMergerBuilderV3<UserapInfo, UserapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserapVisiMergeToSelect());
		InfoMergerV3<UserapInfo, UserapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
