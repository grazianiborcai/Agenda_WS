package br.com.mind5.business.address.info;

import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class AddressMerger {
	public static List<AddressInfo> mergeWithGeosh(List<AddressInfo> baseInfos, List<GeoshInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, GeoshInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeGeosh());
		InfoMergerV3<AddressInfo, GeoshInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithAddarch(List<AddressInfo> baseInfos, List<AddarchInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, AddarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeAddarch());
		InfoMergerV3<AddressInfo, AddarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithAddarchStore(List<AddressInfo> baseInfos, List<AddarchInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, AddarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeAddarchStore());
		InfoMergerV3<AddressInfo, AddarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithUsername(List<AddressInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeUsername());
		InfoMergerV3<AddressInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithCountry(List<AddressInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, CountryInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeCountry());
		InfoMergerV3<AddressInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<AddressInfo> mergeWithFormess(List<AddressInfo> baseInfos, List<FormessInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, FormessInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeFormess());
		InfoMergerV3<AddressInfo, FormessInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithState(List<AddressInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, StateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeState());
		InfoMergerV3<AddressInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeWithAddresnap(List<AddressInfo> baseInfos, List<AddresnapInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, AddresnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeAddresnap());
		InfoMergerV3<AddressInfo, AddresnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeToDelete(List<AddressInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeToDelete());
		InfoMergerV3<AddressInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeToSelect(List<AddressInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeToSelect());
		InfoMergerV3<AddressInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<AddressInfo> mergeToUpdate(List<AddressInfo> baseInfos, List<AddressInfo> selectedInfos) {
		InfoMergerBuilderV3<AddressInfo, AddressInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new AddressVisiMergeToUpdate());
		InfoMergerV3<AddressInfo, AddressInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
