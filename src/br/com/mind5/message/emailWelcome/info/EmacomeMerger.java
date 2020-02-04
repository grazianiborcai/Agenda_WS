package br.com.mind5.message.emailWelcome.info;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class EmacomeMerger {
	public static EmacomeInfo mergeWithOwnelis(OwnelisInfo sourceOne, EmacomeInfo sourceTwo) {
		InfoMerger_<EmacomeInfo, OwnelisInfo> merger = new EmacomeMergerOwnelis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmacomeInfo> mergeWithOwnelis(List<OwnelisInfo> sourceOnes, List<EmacomeInfo> sourceTwos) {
		InfoMerger_<EmacomeInfo, OwnelisInfo> merger = new EmacomeMergerOwnelis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
