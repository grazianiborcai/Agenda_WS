package br.com.mind5.business.employeeSnapshot.info;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.userList.info.UselisInfo;

public final class EmpnapMerger {
	public static List<EmpnapInfo> mergeWithUselis(List<EmpnapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<EmpnapInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergeUselis());
		InfoMerger<EmpnapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPersolis(List<EmpnapInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<EmpnapInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergePersolis());
		InfoMerger<EmpnapInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpnapInfo> mergeWithAddresnap(List<EmpnapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilder<EmpnapInfo, AddresnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergeAddresnap());
		InfoMerger<EmpnapInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPersonap(List<EmpnapInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		InfoMergerBuilder<EmpnapInfo, PersonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergePersonap());
		InfoMerger<EmpnapInfo, PersonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPhonap(List<EmpnapInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilder<EmpnapInfo, PhonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergePhonap());
		InfoMerger<EmpnapInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpnapInfo> mergeToSelect(List<EmpnapInfo> baseInfos, List<EmpnapInfo> selectedInfos) {
		InfoMergerBuilder<EmpnapInfo, EmpnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpnapVisiMergeToSelect());
		InfoMerger<EmpnapInfo, EmpnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
