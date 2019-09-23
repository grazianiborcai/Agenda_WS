package br.com.gda.business.phoneSnapshot.info;

import java.util.List;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.userList.info.UselisInfo;

public final class PhonapMerger {
	public static PhonapInfo mergeWithStolis(StolisInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger<PhonapInfo, StolisInfo> merger = new PhonapMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger<PhonapInfo, StolisInfo> merger = new PhonapMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhonapInfo mergeWithCuslis(CuslisInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger<PhonapInfo, CuslisInfo> merger = new PhonapMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger<PhonapInfo, CuslisInfo> merger = new PhonapMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhonapInfo mergeWithEmplis(EmplisInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger<PhonapInfo, EmplisInfo> merger = new PhonapMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger<PhonapInfo, EmplisInfo> merger = new PhonapMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PhonapInfo mergeWithUselis(UselisInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger<PhonapInfo, UselisInfo> merger = new PhonapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger<PhonapInfo, UselisInfo> merger = new PhonapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhonapInfo mergeWithCountryPhone(CountryPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger<PhonapInfo, CountryPhoneInfo> merger = new PhonapMergerCountryPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithCountryPhone(List<CountryPhoneInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger<PhonapInfo, CountryPhoneInfo> merger = new PhonapMergerCountryPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhonapInfo mergeWithForm(FormPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger<PhonapInfo, FormPhoneInfo> merger = new PhonapMergerForm();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithForm(List<FormPhoneInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger<PhonapInfo, FormPhoneInfo> merger = new PhonapMergerForm();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
