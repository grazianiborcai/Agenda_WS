package br.com.gda.business.address.info;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.info.InfoMerger;

public final class AddressMerger {
	public static AddressInfo mergeWithCountry(CountryInfo sourceOne, AddressInfo sourceTwo) {
		InfoMerger<AddressInfo, CountryInfo> merger = new AddressMergerCountry();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddressInfo> mergeWithCountry(List<CountryInfo> sourceOnes, List<AddressInfo> sourceTwos) {
		InfoMerger<AddressInfo, CountryInfo> merger = new AddressMergerCountry();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddressInfo mergeWithForm(FormAddressInfo sourceOne, AddressInfo sourceTwo) {
		InfoMerger<AddressInfo, FormAddressInfo> merger = new AddressMergerForm();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddressInfo> mergeWithForm(List<FormAddressInfo> sourceOnes, List<AddressInfo> sourceTwos) {
		InfoMerger<AddressInfo, FormAddressInfo> merger = new AddressMergerForm();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddressInfo mergeWithState(StateInfo sourceOne, AddressInfo sourceTwo) {
		InfoMerger<AddressInfo, StateInfo> merger = new AddressMergerState();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddressInfo> mergeWithState(List<StateInfo> sourceOnes, List<AddressInfo> sourceTwos) {
		InfoMerger<AddressInfo, StateInfo> merger = new AddressMergerState();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddressInfo mergeWithAddresnap(AddresnapInfo sourceOne, AddressInfo sourceTwo) {
		InfoMerger<AddressInfo, AddresnapInfo> merger = new AddressMergerAddresnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddressInfo> mergeWithAddresnap(List<AddresnapInfo> sourceOnes, List<AddressInfo> sourceTwos) {
		InfoMerger<AddressInfo, AddresnapInfo> merger = new AddressMergerAddresnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddressInfo mergeToDelete(AddressInfo sourceOne, AddressInfo sourceTwo) {
		InfoMerger<AddressInfo, AddressInfo> merger = new AddressMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddressInfo> mergeToDelete(List<AddressInfo> sourceOnes, List<AddressInfo> sourceTwos) {
		InfoMerger<AddressInfo, AddressInfo> merger = new AddressMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddressInfo mergeToSelect(AddressInfo sourceOne, AddressInfo sourceTwo) {
		InfoMerger<AddressInfo, AddressInfo> merger = new AddressMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddressInfo> mergeToSelect(List<AddressInfo> sourceOnes, List<AddressInfo> sourceTwos) {
		InfoMerger<AddressInfo, AddressInfo> merger = new AddressMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static AddressInfo mergeToUpdate(AddressInfo sourceOne, AddressInfo sourceTwo) {
		InfoMerger<AddressInfo, AddressInfo> merger = new AddressMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddressInfo> mergeToUpdate(List<AddressInfo> sourceOnes, List<AddressInfo> sourceTwos) {
		InfoMerger<AddressInfo, AddressInfo> merger = new AddressMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
