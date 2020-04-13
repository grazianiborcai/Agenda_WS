package br.com.mind5.business.phoneSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class PhonapMerger {
	public static PhonapInfo mergeWithStolis(StolisInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger_<PhonapInfo, StolisInfo> merger = new PhonapMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger_<PhonapInfo, StolisInfo> merger = new PhonapMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhonapInfo mergeWithCuslis(CuslisInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger_<PhonapInfo, CuslisInfo> merger = new PhonapMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger_<PhonapInfo, CuslisInfo> merger = new PhonapMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhonapInfo mergeWithEmplis(EmplisInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger_<PhonapInfo, EmplisInfo> merger = new PhonapMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger_<PhonapInfo, EmplisInfo> merger = new PhonapMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PhonapInfo mergeWithUselis(UselisInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger_<PhonapInfo, UselisInfo> merger = new PhonapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger_<PhonapInfo, UselisInfo> merger = new PhonapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhonapInfo mergeWithCountryPhone(CountryPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger_<PhonapInfo, CountryPhoneInfo> merger = new PhonapMergerCountryPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithCountryPhone(List<CountryPhoneInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger_<PhonapInfo, CountryPhoneInfo> merger = new PhonapMergerCountryPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhonapInfo mergeWithForm(FormoneInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger_<PhonapInfo, FormoneInfo> merger = new PhonapMergerForm();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithForm(List<FormoneInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger_<PhonapInfo, FormoneInfo> merger = new PhonapMergerForm();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
