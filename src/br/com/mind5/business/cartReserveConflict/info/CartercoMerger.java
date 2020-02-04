package br.com.mind5.business.cartReserveConflict.info;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CartercoMerger {	
	public static CartercoInfo mergeWithCarterve(CarterveInfo selectedInfo, CartercoInfo baseInfo) {
		InfoMerger<CartercoInfo, CarterveInfo> merger = new CartercoMergerCarterve();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<CartercoInfo> mergeWithCarterve(List<CarterveInfo> selectedInfos, List<CartercoInfo> baseInfos) {
		InfoMerger<CartercoInfo, CarterveInfo> merger = new CartercoMergerCarterve();		
		return merger.merge(selectedInfos, baseInfos);
	}	
	
	
	
	public static CartercoInfo mergeWithUsername(UsernameInfo selectedInfo, CartercoInfo baseInfo) {
		InfoMerger<CartercoInfo, UsernameInfo> merger = new CartercoMergerUsername();		
		return merger.merge(selectedInfo, baseInfo);
	}
	
	
	
	public static List<CartercoInfo> mergeWithUsername(List<UsernameInfo> selectedInfos, List<CartercoInfo> baseInfos) {
		InfoMerger<CartercoInfo, UsernameInfo> merger = new CartercoMergerUsername();		
		return merger.merge(selectedInfos, baseInfos);
	}	
}
