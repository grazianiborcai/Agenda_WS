package br.com.mind5.business.address.info;

import java.util.List;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class AddressMerger {
	public static List<AddressInfo> mergeWithAddault(List<AddressInfo> baseInfos, List<AddaultInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, AddaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiAddault());
		InfoMerger<AddressInfo, AddaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithGeode(List<AddressInfo> baseInfos, List<GeodeInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, GeodeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiGeode());
		InfoMerger<AddressInfo, GeodeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithGeosh(List<AddressInfo> baseInfos, List<GeoshInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, GeoshInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiGeosh());
		InfoMerger<AddressInfo, GeoshInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithAddarch(List<AddressInfo> baseInfos, List<AddarchInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, AddarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiAddarch());
		InfoMerger<AddressInfo, AddarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithAddarchStore(List<AddressInfo> baseInfos, List<AddarchInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, AddarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiAddarchStore());
		InfoMerger<AddressInfo, AddarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithAddarchPereg(List<AddressInfo> baseInfos, List<AddarchInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, AddarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiAddarchPereg());
		InfoMerger<AddressInfo, AddarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithUsername(List<AddressInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiUsername());
		InfoMerger<AddressInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithCountry(List<AddressInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, CountryInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiCountry());
		InfoMerger<AddressInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<AddressInfo> mergeWithFormess(List<AddressInfo> baseInfos, List<FormessInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, FormessInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiFormess());
		InfoMerger<AddressInfo, FormessInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithState(List<AddressInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiState());
		InfoMerger<AddressInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithAddresnap(List<AddressInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, AddresnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiAddresnap());
		InfoMerger<AddressInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeToDelete(List<AddressInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiToDelete());
		InfoMerger<AddressInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeToSelect(List<AddressInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiToSelect());
		InfoMerger<AddressInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeToUpdate(List<AddressInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilder<AddressInfo, AddressInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressMergerVisiToUpdate());
		InfoMerger<AddressInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
