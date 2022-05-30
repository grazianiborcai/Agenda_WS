package br.com.mind5.security.userSnapshot.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class UserapMerger {	
	public static List<UserapInfo> mergeWithPersolis(List<UserapInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<UserapInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserapMergerVisiPersolis());
		InfoMerger<UserapInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	

	public static List<UserapInfo> mergeWithAddresnap(List<UserapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilder<UserapInfo, AddresnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserapMergerVisiAddresnap());
		InfoMerger<UserapInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
		
	
	
	public static List<UserapInfo> mergeWithPersonap(List<UserapInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		InfoMergerBuilder<UserapInfo, PersonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserapMergerVisiPersonap());
		InfoMerger<UserapInfo, PersonapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<UserapInfo> mergeWithPhonap(List<UserapInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilder<UserapInfo, PhonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserapMergerVisiPhonap());
		InfoMerger<UserapInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<UserapInfo> mergeToSelect(List<UserapInfo> baseInfos, List<UserapInfo> selectedInfos) {
		InfoMergerBuilder<UserapInfo, UserapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserapMergerVisiToSelect());
		InfoMerger<UserapInfo, UserapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
