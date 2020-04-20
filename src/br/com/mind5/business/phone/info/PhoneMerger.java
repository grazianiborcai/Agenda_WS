package br.com.mind5.business.phone.info;

import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PhoneMerger {
	public static List<PhoneInfo> mergeWithPhonarch(List<PhoneInfo> baseInfos, List<PhonarchInfo> selectedInfos) {
		InfoMergerBuilderV3<PhoneInfo, PhonarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneVisiMergePhonarch());
		InfoMergerV3<PhoneInfo, PhonarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeWithUsername(List<PhoneInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<PhoneInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneVisiMergeUsername());
		InfoMergerV3<PhoneInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeWithCountrone(List<PhoneInfo> baseInfos, List<CountroneInfo> selectedInfos) {
		InfoMergerBuilderV3<PhoneInfo, CountroneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneVisiMergeCountryPhone());
		InfoMergerV3<PhoneInfo, CountroneInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PhoneInfo> mergeWithFormone(List<PhoneInfo> baseInfos, List<FormoneInfo> selectedInfos) {
		InfoMergerBuilderV3<PhoneInfo, FormoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneVisiMergeFormone());
		InfoMergerV3<PhoneInfo, FormoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeWithPhonap(List<PhoneInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilderV3<PhoneInfo, PhonapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneVisiMergePhonap());
		InfoMergerV3<PhoneInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PhoneInfo> mergeToDelete(List<PhoneInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<PhoneInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneVisiMergeToDelete());
		InfoMergerV3<PhoneInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeToSelect(List<PhoneInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<PhoneInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneVisiMergeToSelect());
		InfoMergerV3<PhoneInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeToUpdate(List<PhoneInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilderV3<PhoneInfo, PhoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneVisiMergeToUpdate());
		InfoMergerV3<PhoneInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
