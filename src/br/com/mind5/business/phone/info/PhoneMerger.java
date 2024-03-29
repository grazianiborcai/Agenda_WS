package br.com.mind5.business.phone.info;

import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PhoneMerger {
	public static List<PhoneInfo> mergeWithPhonault(List<PhoneInfo> baseInfos, List<PhonaultInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, PhonaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiPhonault());
		InfoMerger<PhoneInfo, PhonaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeWithPhonarch(List<PhoneInfo> baseInfos, List<PhonarchInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, PhonarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiPhonarch());
		InfoMerger<PhoneInfo, PhonarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeWithPhonarchPereg(List<PhoneInfo> baseInfos, List<PhonarchInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, PhonarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiPhonarchPereg());
		InfoMerger<PhoneInfo, PhonarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeWithPhonarchStore(List<PhoneInfo> baseInfos, List<PhonarchInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, PhonarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiPhonarchStore());
		InfoMerger<PhoneInfo, PhonarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeWithPhonarchUser(List<PhoneInfo> baseInfos, List<PhonarchInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, PhonarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiPhonarchUser());
		InfoMerger<PhoneInfo, PhonarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeWithUsername(List<PhoneInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiUsername());
		InfoMerger<PhoneInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeWithCountrone(List<PhoneInfo> baseInfos, List<CountroneInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, CountroneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiCountrone());
		InfoMerger<PhoneInfo, CountroneInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PhoneInfo> mergeWithFormone(List<PhoneInfo> baseInfos, List<FormoneInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, FormoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiFormone());
		InfoMerger<PhoneInfo, FormoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeWithPhonap(List<PhoneInfo> baseInfos, List<PhonapInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, PhonapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiPhonap());
		InfoMerger<PhoneInfo, PhonapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<PhoneInfo> mergeToDelete(List<PhoneInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiToDelete());
		InfoMerger<PhoneInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeToSelect(List<PhoneInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiToSelect());
		InfoMerger<PhoneInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<PhoneInfo> mergeToUpdate(List<PhoneInfo> baseInfos, List<PhoneInfo> selectedInfos) {
		InfoMergerBuilder<PhoneInfo, PhoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PhoneMergerVisiToUpdate());
		InfoMerger<PhoneInfo, PhoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
