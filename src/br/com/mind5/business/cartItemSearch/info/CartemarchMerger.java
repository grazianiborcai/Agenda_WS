package br.com.mind5.business.cartItemSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class CartemarchMerger {
	public static CartemarchInfo mergeToSelect(CartemarchInfo sourceOne, CartemarchInfo sourceTwo) {
		InfoMerger_<CartemarchInfo, CartemarchInfo> merger = new CartemarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemarchInfo> mergeToSelect(List<CartemarchInfo> sourceOnes, List<CartemarchInfo> sourceTwos) {
		InfoMerger_<CartemarchInfo, CartemarchInfo> merger = new CartemarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
