package br.com.gda.business.employeeSnapshot.info;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoMerger;

public final class EmpnapMerger {
	public static EmpnapInfo mergeWithAddresnap(AddresnapInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger<EmpnapInfo, AddresnapInfo> merger = new EmpnapMergerAddresnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithAddresnap(List<AddresnapInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger<EmpnapInfo, AddresnapInfo> merger = new EmpnapMergerAddresnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeWithPersonap(PersonapInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger<EmpnapInfo, PersonapInfo> merger = new EmpnapMergerPersonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPersonap(List<PersonapInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger<EmpnapInfo, PersonapInfo> merger = new EmpnapMergerPersonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeWithPhonap(PhonapInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger<EmpnapInfo, PhonapInfo> merger = new EmpnapMergerPhonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeWithPhonap(List<PhonapInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger<EmpnapInfo, PhonapInfo> merger = new EmpnapMergerPhonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpnapInfo mergeToSelect(EmpnapInfo sourceOne, EmpnapInfo sourceTwo) {
		InfoMerger<EmpnapInfo, EmpnapInfo> merger = new EmpnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpnapInfo> mergeToSelect(List<EmpnapInfo> sourceOnes, List<EmpnapInfo> sourceTwos) {
		InfoMerger<EmpnapInfo, EmpnapInfo> merger = new EmpnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
